package myPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Penguin extends JPanel {
   private Image image;

   public Penguin(String imageResource) throws IOException {
      InputStream inStream = getClass().getResourceAsStream(imageResource);
      image = ImageIO.read(inStream);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, this);
      }
   }
}