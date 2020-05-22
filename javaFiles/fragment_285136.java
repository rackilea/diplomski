import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class Draw extends JPanel {

   private static final int PREF_W = 800;
   private static final int PREF_H = PREF_W;
   private BufferedImage image;

   public Draw(String[] params) throws IOException {
      if (params != null && params.length > 0) {
         image = ImageIO.read(new File(params[0]));
      }
      // this.setSize(800,800);
      JPanel drawing = new JPanel();
      drawing.setOpaque(false); // may need this
      this.add(drawing);
      this.setVisible(true);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      } else {

      }

   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }

      // not sure if you want to size it to the image or not
      if (image != null) {
         int w = image.getWidth();
         int h = image.getHeight();
         return new Dimension(w, h);
      } else {
         return new Dimension(PREF_W, PREF_H);
      }
   }

   public static void main(String[] args) {
      // create new Jframe
      JFrame frame = new JFrame("Draw");
      try {
         frame.add(new Draw(args));
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         // frame.setSize(500,500);
         frame.pack();
         frame.setVisible(true);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}