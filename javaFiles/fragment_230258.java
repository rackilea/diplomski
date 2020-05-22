import java.net.URL;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class RestartableLoopSound {

    public static void main(String[] args) throws Exception {
        URL url = new URL(
            "http://pscode.org/media/leftright.wav");
        final Clip clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.
            getAudioInputStream( url );
        clip.open(ais);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JToggleButton b = new JToggleButton("Loop");
                ActionListener listener = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (b.isSelected()) {
                            // loop continuously
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        } else {
                            clip.stop();
                        }
                    }
                };
                b.addActionListener(listener);
                JOptionPane.showMessageDialog(null, b);
            }
        });
    }
}