import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Test2 {
   private static final int LP_WIDTH = 450;
   private static final int LP_HEIGHT = 600;
   private static final String IMAGE_SITE = "http://upload.wikimedia.org/wikipedia/"
         + "commons/thumb/b/b8/Laser_Towards_Milky_Ways_Centre.jpg/"
         + "660px-Laser_Towards_Milky_Ways_Centre.jpg";
   private JLayeredPane layeredPanel = new JLayeredPane();

   public Test2() {
      layeredPanel.setPreferredSize(new Dimension(LP_WIDTH, LP_HEIGHT));
      try {
         URL url = new URL(IMAGE_SITE);
         BufferedImage image = ImageIO.read(url);
         ImagePanel2 imagePanel2 = new ImagePanel2(image);
         imagePanel2.setSize(layeredPanel.getPreferredSize());

         JPanel buttonPanel = new JPanel();
         buttonPanel.setOpaque(false);
         for (int i = 0; i < 8; i++) {
            buttonPanel.add(new JButton("Button"));
         }
         buttonPanel.setSize(layeredPanel.getPreferredSize());

         layeredPanel.add(imagePanel2, JLayeredPane.DEFAULT_LAYER);
         layeredPanel.add(buttonPanel, JLayeredPane.PALETTE_LAYER);
      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }

   private JComponent getMainComponent() {
      return layeredPanel;
   }

   private static void createAndShowGui() {
      Test2 test2 = new Test2();

      JFrame frame = new JFrame("Test2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(test2.getMainComponent());
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class ImagePanel2 extends JPanel {
   private Image image;

   public ImagePanel2(Image image) {
      this.image = image;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      }
   }

}