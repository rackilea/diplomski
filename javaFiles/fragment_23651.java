import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class MyPanel extends JPanel {
   private BufferedImage img;

   public MyPanel(BufferedImage img) {
      this.img = img;
      setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, this); // corrected
      }
   }
}