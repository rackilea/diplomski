import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPaint extends JPanel {
   public static final int IMG_WIDTH = 400;
   public static final int IMG_HEIGHT = IMG_WIDTH;

   private BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
            BufferedImage.TYPE_INT_ARGB);

   public MyPaint() {
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(IMG_WIDTH, IMG_HEIGHT);
   }

   public void clearScreen() {
      Graphics g = image.getGraphics();
      g.setColor(Color.black);
      g.fillRect(0, 0, image.getWidth(), image.getHeight());
      g.dispose();
      repaint();
   }

   private class MyMouseAdapter extends MouseAdapter {
      // code to draw on the buffered image. 
      // Don't forget to call repaint() on the "this" JPanel
   }
}