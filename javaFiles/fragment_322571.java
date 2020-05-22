import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SavedImageDisplayer {

    public static void main(String[] args) throws IOException {
        BufferedImage img = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        final File file = new File("testImg.png");
        ImageIO.write(img, "png", file);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ImageIcon imageIcon;
                try {
                    // use the File as basis for the URL!
                    imageIcon = new ImageIcon(file.toURI().toURL());
                    JOptionPane.showMessageDialog(null, imageIcon);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}