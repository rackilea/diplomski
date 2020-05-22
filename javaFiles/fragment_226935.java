import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SubImageEg extends JPanel {
   // images from Wikimedia Commons
   // http://commons.wikimedia.org/wiki/Main_Page
   public static final String MAIN_IMG_PATH = "http://upload.wikimedia.org/wikipedia/commons/" +
        "thumb/4/43/Sarcophilus_harrisii_taranna.jpg/800px-Sarcophilus_harrisii_taranna.jpg";
   public static final String SECOND_IMG_PATH = "http://upload.wikimedia.org/wikipedia/commons/" +
        "thumb/f/f8/Soldering_a_0805.jpg/800px-Soldering_a_0805.jpg";
   public static final String[] IMAGE_PATHS = {MAIN_IMG_PATH, SECOND_IMG_PATH};
   private static final int SUB_X = 520;
   private static final int SUB_Y = 340;
   private static final int SUB_W = 150;
   private static final int SUB_H = 150;
   private static final int SEC_SUB_X = 400;
   private static final int SEC_SUB_Y = 200;

   private BufferedImage[] images = new BufferedImage[IMAGE_PATHS.length];
   private BufferedImage secondImgSubImg;

   public SubImageEg() {
      try {
         for (int i = 0; i < IMAGE_PATHS.length; i++) {
            images[i] = ImageIO.read(new URL(IMAGE_PATHS[i]));
         }

         secondImgSubImg = images[1].getSubimage(SUB_X, SUB_Y, SUB_W, SUB_H);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (images[0] != null) {
         g.drawImage(images[0], 0, 0, this);
      }
      if (secondImgSubImg != null) {
         g.drawImage(secondImgSubImg, SEC_SUB_X, SEC_SUB_Y, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (images[0] != null) {
         return new Dimension(images[0].getWidth(), images[0].getHeight());
      } else {
         return super.getPreferredSize();
      }
   }

   private static void createAndShowGui() {
      SubImageEg mainPanel = new SubImageEg();

      JFrame frame = new JFrame("SubImageEg");
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