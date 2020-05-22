import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawStuff extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final Color POINTS_COLOR = Color.red;
   private static final Color CURRENT_POINTS_COLOR = Color.blue;
   private static final Stroke STROKE = new BasicStroke(4f);
   private List<List<Point>> pointsList = new ArrayList<List<Point>>();
   private List<Point> currentPointList = null;

   public DrawStuff() {
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(STROKE);
      g.setColor(POINTS_COLOR);
      for (List<Point> pointList : pointsList) {
         if (pointList.size() > 1) {
            Point p1 = pointList.get(0);
            for (int i = 1; i < pointList.size(); i++) {
               Point p2 = pointList.get(i);
               int x1 = p1.x;
               int y1 = p1.y;
               int x2 = p2.x;
               int y2 = p2.y;
               g.drawLine(x1, y1, x2, y2);
               p1 = p2;
            }
         }
      }
      g.setColor(CURRENT_POINTS_COLOR);
      if (currentPointList != null && currentPointList.size() > 1) {
         Point p1 = currentPointList.get(0);
         for (int i = 1; i < currentPointList.size(); i++) {
            Point p2 = currentPointList.get(i);
            int x1 = p1.x;
            int y1 = p1.y;
            int x2 = p2.x;
            int y2 = p2.y;
            g.drawLine(x1, y1, x2, y2);
            p1 = p2;
         }
      }
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent mEvt) {
         currentPointList = new ArrayList<Point>();
         currentPointList.add(mEvt.getPoint());
         repaint();
      }

      @Override
      public void mouseDragged(MouseEvent mEvt) {
         currentPointList.add(mEvt.getPoint());
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent mEvt) {
         currentPointList.add(mEvt.getPoint());
         pointsList.add(currentPointList);
         currentPointList = null;
         repaint();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("DrawStuff");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new DrawStuff());
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