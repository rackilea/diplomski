import javax.sound.sampled.LineListener;
import javax.swing.*;

class TwoClips {

    public static void main(String[] args) throws Exception {
        URL url1 = new URL("http://pscode.org/media/100_2817-linear.wav");
        URL url2 = new URL("http://pscode.org/media/leftright.wav");
        final Clip clip1 = AudioSystem.getClip();
        clip1.open(AudioSystem.getAudioInputStream(url1));
        final Clip clip2 = AudioSystem.getClip();
        clip2.open(AudioSystem.getAudioInputStream(url2));
        LineListener listener = new LineListener() {

            Clip currentClip = clip1;

            @Override
            public void update(LineEvent event) {
                if (event.getType() == LineEvent.Type.STOP) {
                    if (currentClip == clip1) {
                        currentClip = clip2;
                    } else {
                        currentClip = clip1;
                    }
                    currentClip.setFramePosition(0);
                    currentClip.start();
                }
            }
        };
        clip1.addLineListener(listener);
        clip2.addLineListener(listener);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                clip1.start();
                JOptionPane.showMessageDialog(null, "Close me to exit!");
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}