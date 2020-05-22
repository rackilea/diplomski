import javax.swing.*;
import java.net.URL;
import java.awt.Image;
import javax.imageio.ImageIO;

class ButtonRollover {
    public static void main(String[] args) throws Exception {
        URL imageUrl2 = new URL("http://pscode.org/media/stromlo2.jpg");
        URL imageUrl1 = new URL("http://pscode.org/media/stromlo1.jpg");

        final Image image2 = ImageIO.read(imageUrl2);
        final Image image1 = ImageIO.read(imageUrl1);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JButton button = new JButton("Hover Me!");

                button.setIcon(new ImageIcon(image2));
                button.setRolloverIcon(new ImageIcon(image1));

                JOptionPane.showMessageDialog(null, button);
            }
        });
    }
}