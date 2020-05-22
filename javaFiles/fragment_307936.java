import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MandelDraw extends JPanel {
private static final String IMAGE_ADDR = "http://upload.wikimedia.org/" +
        "wikipedia/commons/thumb/b/b3/Mandel_zoom_07_satellite.jpg/" +
        "800px-Mandel_zoom_07_satellite.jpg";
private static final Color DRAWING_RECT_COLOR = new Color(200, 200, 255);
private static final Color DRAWN_RECT_COLOR = Color.blue;

   private BufferedImage image;
   private Rectangle rect = null;
   private boolean drawing = false;

   public MandelDraw() {
      try {
         image = ImageIO.read(new URL(IMAGE_ADDR));
         MyMouseAdapter mouseAdapter = new MyMouseAdapter();
         addMouseListener(mouseAdapter);
         addMouseMotionListener(mouseAdapter);
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
      if (image != null) {
         return new Dimension(image.getWidth(), image.getHeight());
      }
      return super.getPreferredSize();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      }
      if (rect == null) {
         return;
      } else if (drawing) {
         g2.setColor(DRAWING_RECT_COLOR);
         g2.draw(rect);
      } else {
         g2.setColor(DRAWN_RECT_COLOR);
         g2.draw(rect);
      }
   }

   private class MyMouseAdapter extends MouseAdapter {
      private Point mousePress = null; 
      @Override
      public void mousePressed(MouseEvent e) {
         mousePress = e.getPoint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         drawing = true;
         int x = Math.min(mousePress.x, e.getPoint().x);
         int y = Math.min(mousePress.y, e.getPoint().y);
         int width = Math.abs(mousePress.x - e.getPoint().x);
         int height = Math.abs(mousePress.y - e.getPoint().y);

         rect = new Rectangle(x, y, width, height);
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         drawing = false;
         repaint();
      }

   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("MandelDraw");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MandelDraw());
      frame.pack();
      frame.setLocationRelativeTo(null);
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