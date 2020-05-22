import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestPlayer {

    public static void main(String[] args) {
        new TestPlayer();
    }

    public TestPlayer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (LineUnavailableException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private Clip clip;
        private List<File> playList;
        private int index;

        private JLabel label;

        public TestPane() throws LineUnavailableException {
            label = new JLabel("Play stuff");
            add(label);
            clip = AudioSystem.getClip();

            File[] files = new File("A folder of music files").listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().toLowerCase().endsWith(".wav");
                }
            });
            playList = new ArrayList<>(Arrays.asList(files));
            index = -1;

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "previous");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "next");

            ActionMap am = getActionMap();
            am.put("next", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playNext();
                }
            });
            am.put("previous", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playPrevious();
                }
            });
        }

        public void playNext() {
            index++;
            if (index >= playList.size()) {
                index = 0;
            }

            File file = playList.get(index);

            play(file);
        }

        public void playPrevious() {
            index--;
            if (index < 0) {
                index = playList.size() - 1;
            }

            File file = playList.get(index);

            play(file);
        }

        public void play(File file) {

            try {
                stop();
                label.setText(file.getName());
                AudioInputStream sample = AudioSystem.getAudioInputStream(file);
                clip.open(sample);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exp) {
                exp.printStackTrace();
            }
        }

        public void stop() {

            clip.stop();
            clip.close();

        }

    }

}