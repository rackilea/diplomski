import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawMovePolygonMain extends JPanel {
   private DrawPolygonPanel drawPolygonPanel = new DrawPolygonPanel();
   private MyMouseListener myMouseListener = new MyMouseListener();

   public DrawMovePolygonMain() {
      drawPolygonPanel.addMouseListener(myMouseListener);

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(createDrawToggleButton());
      for (PolyDirection dir : PolyDirection.values()) {
         buttonPanel.add(new JButton(new DirectionAction(dir)));
      }

      setLayout(new BorderLayout());
      add(drawPolygonPanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);
   }

   private JComponent createDrawToggleButton() {
      JToggleButton toggleButton = new JToggleButton("Draw Poly Points");
      toggleButton.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               drawPolygonPanel.clearPoly();
               drawPolygonPanel.resetPoints();
               myMouseListener.setEnabled(true);
            } else {
               myMouseListener.setEnabled(false);
               Path2D poly = new Path2D.Double();
               List<Point> points = drawPolygonPanel.getPoints();
               if (points == null || points.size() == 0) {
                  return;
               }
               poly.moveTo(points.get(0).getX(), points.get(0).getY());
               for (Point point : points) {
                  poly.lineTo(point.getX(), point.getY());
               }
               poly.closePath();
               drawPolygonPanel.clearPoints();
               drawPolygonPanel.setPoly(poly);
            }
         }
      });
      return toggleButton;
   }

   private class DirectionAction extends AbstractAction {
      private PolyDirection dir;

      public DirectionAction(PolyDirection dir) {
         super(dir.name());
         this.dir = dir;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         drawPolygonPanel.move(dir);
      }
   }

   private class MyMouseListener extends MouseAdapter {

      private boolean enabled;

      public void setEnabled(boolean enabled) {
         this.enabled = enabled;
      }

      @Override
      public void mousePressed(MouseEvent e) {
         if (enabled) {
            drawPolygonPanel.addPoint(e.getPoint());
         }
      }
   }

   private static void createAndShowGui() {
      DrawMovePolygonMain mainPanel = new DrawMovePolygonMain();

      JFrame frame = new JFrame("DrawMovePolygonMain");
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

@SuppressWarnings("serial")
class DrawPolygonPanel extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private static final Color POLY_COLOR = Color.red;
   private static final Color POLY_EDGE_COLOR = Color.blue;
   private static final Stroke EDGE_STROKE = new BasicStroke(3f,
         BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
   private static final double SCALE = 10.0;
   private static final int PT_RADIUS = 4;
   private Path2D poly;
   private List<Point> points = new ArrayList<>();

   public void move(PolyDirection direction) {

      double tx = direction.getTx() * SCALE;
      double ty = direction.getTy() * SCALE;
      AffineTransform transform = AffineTransform.getTranslateInstance(tx, ty);
      poly.transform(transform);
      repaint();
   }

   public void resetPoints() {
      points = new ArrayList<>();
   }

   public void setPoly(Path2D poly) {
      this.poly = poly;
      repaint();
   }

   public void clearPoly() {
      poly = null;
      repaint();
   }

   public void addPoint(Point p) {
      if (points != null) {
         points.add(p);
      }
      repaint();
   }

   public List<Point> getPoints() {
      return points;
   }

   public void clearPoints() {
      points = null;
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (poly != null) {

         Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setColor(POLY_COLOR);
         if (poly != null) {
            g2.fill(poly);
         }
         g2.setColor(POLY_EDGE_COLOR);
         Stroke oldStroke = g2.getStroke();
         g2.setStroke(EDGE_STROKE);
         g2.draw(poly);

         g2.setStroke(oldStroke);
      }

      if (points != null && points.size() > 0) {
         g.setColor(Color.black);
         Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
         for (Point pt : points) {
            int x = pt.x - PT_RADIUS;
            int y = pt.y - PT_RADIUS;
            int width = 2 * PT_RADIUS;
            int height = width;
            g.fillOval(x, y, width, height);
         }
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }   

}

enum PolyDirection {
   UP(0.0, -1.0), DOWN(0.0, 1.0), LEFT(-1.0, 0.0), RIGHT(1.0, 0.0);

   private double tx;
   private double ty;

   private PolyDirection(double tx, double ty) {
      this.tx = tx;
      this.ty = ty;
   }

   public double getTx() {
      return tx;
   }

   public double getTy() {
      return ty;
   }
}