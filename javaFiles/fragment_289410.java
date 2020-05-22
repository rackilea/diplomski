import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class PlayWithImages extends JLayeredPane {
   private static final String RESOURCE = "/cardimages/tenClubs.gif";
   private static final int PREF_W = 500;
   private static final int PREF_H = PREF_W;
   private static final int CARD_COUNT = 8;

   public PlayWithImages() throws IOException {
      URL url = getClass().getResource(RESOURCE);
      BufferedImage img = ImageIO.read(url);
      Icon icon = new ImageIcon(img);

      for (int i = 0; i < CARD_COUNT; i++) {
         JLabel label = new JLabel(icon);
         label.setSize(label.getPreferredSize());
         int x = PREF_W - 20 - i * 40 - label.getWidth();
         int y = 20;
         label.setLocation(x, y);
         add(label);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      PlayWithImages mainPanel = null;
      try {
         mainPanel = new PlayWithImages();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("PlayWithImages");
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