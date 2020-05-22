import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JSlider slider = new JSlider(0, 100);
        private long frameCount;
        private double duration;

        private AudioFormat format;
        private Clip clip;

        private JLabel currentFrame;
        private JLabel currentDuration;

        private boolean playing = false;

        private Timer playTimer;

        private boolean ignoreStateChange = false;

        public TestPane() {
            AudioInputStream ais = null;
            try {
                File file = new File(System.getProperty("user.home") + "/Library/Application Support/Steam/Steam.AppBundle/Steam/Contents/MacOS/friends/voice_hang_up.wav");
                ais = AudioSystem.getAudioInputStream(file);
                format = ais.getFormat();
                frameCount = ais.getFrameLength();
                duration = ((double) frameCount) / format.getFrameRate();

                clip = AudioSystem.getClip();
                clip.open(ais);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                ex.printStackTrace();
            }
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            setLayout(new GridBagLayout());
            add(slider, gbc);
            slider.setValue(0);

            add(new JLabel("Total Frames: " + frameCount), gbc);
            add(new JLabel("Total Duration: " + duration), gbc);

            currentFrame = new JLabel("Current frame: 0");
            currentDuration = new JLabel("Current duration: 0");

            add(currentFrame, gbc);
            add(currentDuration, gbc);

            JButton action = new JButton("Play");
            action.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!playing) {
                        int frame = getDesiredFrame();
                        if (frame >= frameCount) {
                            frame = 0;
                        }
                        clip.setFramePosition(frame);
                        clip.start();
                        action.setText("Stop");
                        playing = true;
                        playTimer.start();
                    } else {
                        clip.stop();
                        action.setText("Play");
                        playing = false;
                        playTimer.stop();
                    }
                }
            });

            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType().equals(Type.STOP)
                                    || event.getType().equals(Type.CLOSE)) {
                        action.setText("Play");                     
                        playing = false;
                        playTimer.stop();
                        updateState();
                    }
                }
            });

            add(action, gbc);

            playTimer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateState();
                }
            });

            Timer delayedUpdate = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int frame = getDesiredFrame();
                    clip.setFramePosition(frame);

                    double time = getCurrentTime();

                    currentFrame.setText("Current frame: " + frame);
                    currentDuration.setText("Current duration: " + time);

                }
            });
            delayedUpdate.setRepeats(false);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (ignoreStateChange) {
                        return;
                    }
                    delayedUpdate.restart();
                }
            });
        }

        public void updateState() {
            ignoreStateChange = true;
            int frame = clip.getFramePosition();
            int progress = (int) (((double) frame / (double) frameCount) * 100);
            slider.setValue(progress);
            currentFrame.setText("Current frame: " + getDesiredFrame());
            currentDuration.setText("Current duration: " + getCurrentTime());
            ignoreStateChange = false;
        }

        public double getCurrentTime() {
            int currentFrame = clip.getFramePosition();
            double time = (double) currentFrame / format.getFrameRate();
            return time;
        }

        public int getDesiredFrame() {
            int progress = slider.getValue();
            double frame = ((double) frameCount * ((double) progress / 100.0));
            return (int) frame;
        }

    }

}