import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class TwoBecomeOne {
    public static void main(String[] args) throws IOException {
        BufferedImage large = ImageIO.read(new File("images/tiger.jpg"));
        BufferedImage small = ImageIO.read(new File("images/bclynx.jpg"));
        int w = large.getWidth();
        int h = large.getHeight();
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage image = new BufferedImage(w, h, type);
        Graphics2D g2 = image.createGraphics();
        g2.drawImage(large, 0, 0, null);
        g2.drawImage(small, 10, 10, null);
        g2.dispose();
        ImageIO.write(image, "jpg", new File("twoInOne.jpg"));
        JOptionPane.showMessageDialog(null, new ImageIcon(image), "",
                                      JOptionPane.PLAIN_MESSAGE);
    }
}