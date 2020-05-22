import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConvertBuffer {

    public static void main(String[] args) {
        try {
            BufferedImage before = ImageIO.read(new File("/Before.jpg"));
            BufferedImage after = ImageIO.read(new File("/After.jpg"));

            BufferedImage result = bufferedImagesEqual(before, after);

            JLabel label = new JLabel(new ImageIcon(result));
            label.setOpaque(true);
            label.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(null, label);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage bufferedImagesEqual(BufferedImage prevImage,
                    BufferedImage currImage) {
        boolean changed = false;
        BufferedImage imagePart = new BufferedImage(currImage.getWidth(), currImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        if (prevImage.getWidth() == currImage.getWidth()
                        && prevImage.getHeight() == currImage.getHeight()) {

            for (int x = 0; x < currImage.getWidth(); x++) {
                for (int y = 0; y < prevImage.getHeight(); y++) {
                    if (prevImage.getRGB(x, y) != currImage.getRGB(x, y)) {
                //  return false;
                        //  currImage.setRGB(x, y, 0);
                        if (!changed) {
                            changed = true;
                        }
                        imagePart.setRGB(x, y, currImage.getRGB(x, y));
                    } else {
                        imagePart.setRGB(x, y, new Color(0, 0, 0, 0).getRGB());
                    }
                }
            }
        } else {
            return imagePart;
        }
        if (changed) {
            return imagePart;
        } else {
            return null;
        }
    }

}