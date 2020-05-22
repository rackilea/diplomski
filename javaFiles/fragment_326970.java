import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ButtonOnImg extends JPanel {
   public static final String IMG_PATH = "https://duke.kenai.com/gun/Gun.jpg";
   private BufferedImage img;

   public ButtonOnImg() throws IOException {
      URL url = new URL(IMG_PATH);
      img = ImageIO.read(url);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, null);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (img == null) {
         return super.getPreferredSize();
      } else {
         int w = img.getWidth();
         int h = img.getHeight();
         return new Dimension(w, h);
      }
   }

   private static void createAndShowGui() {
      try {
         ButtonOnImg mainPanel = new ButtonOnImg();

         mainPanel.add(new JButton("Button!"));

         JFrame frame = new JFrame("ButtonOnImg");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.getContentPane().add(mainPanel);
         frame.pack();
         frame.setLocationByPlatform(true);
         frame.setVisible(true);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}