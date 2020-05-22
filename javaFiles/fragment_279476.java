import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @see https://stackoverflow.com/a/17130160/230513
 * @see http://pscode.org/media/
 * @see http://www.soundjay.com/beep-sounds-1.html
 */
public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        f.add(new JButton(new SoundAction("Play 1",
            "http://pscode.org/media/leftright.wav")));
        f.add(new JButton(new SoundAction("Play 2",
            "http://www.soundjay.com/button/beep-1.wav")));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    class SoundAction extends AbstractAction {

        private Clip clip;

        public SoundAction(String name, String location) {
            super(name);
            try {
                URL url = new URL(location);
                AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(ais);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Runnable optional
            Runnable soundPlayer = new Runnable() {
                @Override
                public void run() {
                    try {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    } catch (Exception e) {
                        e.printStackTrace(System.err);
                    }
                }
            };
            new Thread(soundPlayer).start();
        }
    }
}