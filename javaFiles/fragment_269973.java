import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.net.URL;

class TestRolloverIcon {

    public static void main(String[] args) throws Exception {
        URL url2 = new URL("http://pscode.org/media/citymorn2.jpg");
        final BufferedImage image2 = ImageIO.read(url2);
        final BufferedImage image1 = new BufferedImage(
            image2.getWidth(),image2.getHeight(),BufferedImage.TYPE_INT_ARGB);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JButton button = new JButton("Point at space (there's a lot of it)!");
                button.setIcon(new ImageIcon(image1));
                button.setRolloverIcon(new ImageIcon(image2));

                JOptionPane.showMessageDialog(null, button);
            }
        });
    }
}