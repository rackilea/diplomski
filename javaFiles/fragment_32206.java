import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
   private static final int PREF_W = 450;
   private static final int PREF_H = 300;
   private static final int SMALL_SQR_SIZE = 10;
   private static final Stroke STROKE_5 = new BasicStroke(5f);
   private static final Stroke STROKE_2 = new BasicStroke(2f);
   private static final Color[] COLORS = { Color.MAGENTA, Color.CYAN, Color.RED,
         Color.BLUE, Color.PINK, Color.yellow };
   private Random random = new Random();
   private BufferedImage background;
   private Map<Shape, Color> shapes = new LinkedHashMap<>(); // so order is maintained
   private Shape drawingShape = null;

   public DrawPanel() {
      background = createBackground();
      MyMouseAdapater myMouseAdapater = new MyMouseAdapater();
      addMouseListener(myMouseAdapater);
      addMouseMotionListener(myMouseAdapater);
   }

   private BufferedImage createBackground() {
      BufferedImage bg = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = bg.createGraphics();
      g2.setPaint(Color.red);
      // g2.setStroke(new BasicStroke(BASIC_STROKE_POINTS));
      for (int i = 0; i < PREF_W; i += SMALL_SQR_SIZE) {
         g2.drawLine(i, 0, i, PREF_H);
      }

      for (int i = 0; i < PREF_H; i += SMALL_SQR_SIZE) {
         g2.drawLine(0, i, PREF_W, i);
      }

      g2.dispose();
      return bg;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (background != null) {
         g.drawImage(background, 0, 0, null);
      }
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(STROKE_2);
      for (Shape shape : shapes.keySet()) {
         g2.setColor(Color.black);
         g2.draw(shape);
         g2.setColor(shapes.get(shape));
         g2.fill(shape);
      }
      if (drawingShape != null) {
         g2.setStroke(STROKE_5);
         g2.setColor(Color.DARK_GRAY);
         g2.draw(drawingShape);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyMouseAdapater extends MouseAdapter {
      private Point initP = null;
      @Override
      public void mousePressed(MouseEvent e) {
         if (e.getButton() != MouseEvent.BUTTON1) {
            return;
         }
         initP = e.getPoint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (initP == null) {
            return;
         }
         Point p = e.getPoint();
         drawingShape = makeRectangle(p.x, p.y, initP.x, initP.y);
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (initP == null) {
            return;
         }
         Point p = e.getPoint();
         Shape newShape = makeRectangle(p.x, p.y, initP.x, initP.y);
         shapes.put(newShape, COLORS[random.nextInt(COLORS.length)]);

         drawingShape = null;
         initP = null;
         repaint();         
      }

      private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
         return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2),
               Math.abs(x1 - x2), Math.abs(y1 - y2));
      }
   }

   private static void createAndShowGui() {
      DrawPanel mainPanel = new DrawPanel();

      JFrame frame = new JFrame("DrawPanel");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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