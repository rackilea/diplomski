import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(Main.class.getResource("/Block.jpg"));
            BufferedImage rotate = rotate(img.getHeight(), img.getWidth(), img, 90);

            JPanel panel = new JPanel();
            panel.add(new JLabel(new ImageIcon(img)));
            panel.add(new JLabel(new ImageIcon(rotate)));

            JOptionPane.showMessageDialog(null, panel);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static BufferedImage rotate(int height, int width, BufferedImage originalImg, int angle) {
        BufferedImage rotateImage = null;
        try {
            rotateImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
            AffineTransform a90 = AffineTransform.getRotateInstance(Math.toRadians(angle), height / 2, width / 2);
            AffineTransformOp op90 = new AffineTransformOp(a90, AffineTransformOp.TYPE_BILINEAR);
            op90.filter(originalImg, rotateImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotateImage;
    }

}