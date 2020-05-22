import java.awt.Image;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.net.URL;

class TestRolloverIcon {

    public static void main(String[] args) throws Exception {
        URL url1 = new URL("http://pscode.org/media/citymorn1.jpg");
        URL url2 = new URL("http://pscode.org/media/citymorn2.jpg");
        final Image image1 = ImageIO.read(url1);
        final Image image2 = ImageIO.read(url2);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JButton button = new JButton("Point at the Moon!");
                button.setIcon(new ImageIcon(image1));
                button.setRolloverIcon(new ImageIcon(image2));

                JOptionPane.showMessageDialog(null, button);
            }
        });
    }
}