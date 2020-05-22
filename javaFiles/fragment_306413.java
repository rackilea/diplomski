import javax.swing.*;
import java.net.URL;

class AnimatedGifInLabelWithText {

    public static void main(String[] args) throws Exception {
        final URL url = new URL("http://pscode.org/media/starzoom-thumb.gif");
        Runnable r = new Runnable() {
            public void run() {
                ImageIcon ii = new ImageIcon(url);
                JLabel label = new JLabel("Zoom!", ii, SwingConstants.CENTER);
                JOptionPane.showMessageDialog(null, label);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}