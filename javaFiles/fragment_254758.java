import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Test3 extends JPanel {
   private static final int LP_WIDTH = 450;
   private static final int LP_HEIGHT = 600;
   private static final String IMAGE_SITE = "http://upload.wikimedia.org/wikipedia/"
         + "commons/thumb/b/b8/Laser_Towards_Milky_Ways_Centre.jpg/"
         + "660px-Laser_Towards_Milky_Ways_Centre.jpg";

   private BufferedImage image;

   public Test3() {
      try {
         URL url = new URL(IMAGE_SITE);
         image = ImageIO.read(url);

         for (int i = 0; i < 8; i++) {
            add(new JButton("Button"));
         }
      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(LP_WIDTH, LP_HEIGHT);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      }
   }

   private static void createAndShowGui() {
      Test3 mainPanel = new Test3();

      JFrame frame = new JFrame("Test3");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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