import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CanvasPanel extends JPanel {
   List<Point> points = new ArrayList<>();
   // Use compositon over inheritance.
   // Don't extend JFrame unless you plan to override something.
   JFrame      frame  = new JFrame();

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new CanvasPanel());
   }
   public CanvasPanel() {
      MyMouseListener ml = new MyMouseListener();
      addMouseMotionListener(ml);
      addMouseListener(ml);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setPreferredSize(new Dimension(500, 500));
      frame.add(this);
      frame.pack();
      frame.setLocationRelativeTo(null); // center on screen
      frame.setVisible(true);
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.black);
      if (points.size() >= 2) {
         Iterator<Point> it = points.iterator();
         Point p1 = it.next();
         while (it.hasNext()) {
            Point p2 = it.next();
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
            p1 = p2;
         }
      }
   }

   // MouseAdapter provides dummy implementations
   private class MyMouseListener extends MouseAdapter {
      public void mouseDragged(MouseEvent me) {
         points.add(me.getPoint());
         repaint();

      }
      public void mousePressed(MouseEvent me) {
         // initialize first point in list.
         points.add(me.getPoint());
      }
   }
}