import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ViewControl {

   private static void createAndShowGui() {
      View view = new View();
      Control control = new Control(view);
      view.addMouseAdapter(control);

      JFrame frame = new JFrame("ViewControl");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(view);
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
class View extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private List<Point> points = new ArrayList<Point>();

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (points.size() > 1) {
         for (int i = 0; i < points.size() - 1; i++) {
            int x1 = points.get(i).x;
            int y1 = points.get(i).y;
            int x2 = points.get(i + 1).x;
            int y2 = points.get(i + 1).y;

            g.drawLine(x1, y1, x2, y2);
         }
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void addMouseAdapter(MouseAdapter adapter) {
      // addMouseListener(adapter);
      addMouseMotionListener(adapter);
   }

   public void addPoint(Point p) {
      points.add(p);
      repaint();
   }
}

class Control extends MouseAdapter {
   private View view;

   public Control(View view) {
      this.view = view;
   }

   @Override
   public void mouseDragged(MouseEvent e) {
      view.addPoint(e.getPoint());
   }
}