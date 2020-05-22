import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TestImage {
   public TestImage() throws IOException {
      String path = "/res/Title.png";
      BufferedImage img = ImageIO.read(getClass().getResource(path));
      ImageIcon icon = new ImageIcon(img);
      JOptionPane.showMessageDialog(null, icon);
   }
   public static void main(String[] args) {
      try {
         new TestImage();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}