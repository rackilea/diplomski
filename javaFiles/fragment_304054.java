import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class LineDrawEg {

   private static void createAndShowGui() {
      JPanel mainPanel = new JPanel(new GridLayout(1, 0));
      mainPanel.setPreferredSize(new Dimension(800, 400));

      MyMouseAdapter mouseAdapter = new MyMouseAdapter();
      JPanel[] panels = {new Panel1(), new Panel2()};
      for (int i = 0; i < panels.length; i++) {
         String title = "Panel " + (i + 1);
         Border border = new TitledBorder(title);
         panels[i].setBorder(border);
         panels[i].addMouseListener(mouseAdapter);
         panels[i].addMouseMotionListener(mouseAdapter);
         mainPanel.add(panels[i]);
      }

      JFrame frame = new JFrame("Line Draw Eg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

class Panel1 extends JPanel implements Positionable {
   private int xPos = 0;
   private int yPos = 0;

   @Override
   protected void paintComponent(Graphics g) {
      // super.paintComponent(g);
      g.setColor(Color.red);
      g.fillOval(xPos, yPos, 5, 5);
   }

   @Override
   public void mouseDragged(Point p) {
      xPos = p.x;
      yPos = p.y;
      repaint();
   }

   @Override
   public void mousePressed(Point p) {
      xPos = p.x;
      yPos = p.y;
      repaint();
   }

   @Override
   public void mouseReleased(Point p) {
      xPos = p.x;
      yPos = p.y;
      repaint();
   }

}

class Panel2 extends JPanel implements Positionable {
   private List<List<Point>> listOfLists = new ArrayList<List<Point>>();
   private List<Point> currentPoints;

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(5f));
      if (currentPoints != null && currentPoints.size() > 1) {
         g2.setColor(Color.blue);
         for (int i = 1; i < currentPoints.size(); i++) {
            int x1 = currentPoints.get(i - 1).x;
            int y1 = currentPoints.get(i - 1).y;
            int x2 = currentPoints.get(i).x;
            int y2 = currentPoints.get(i).y;
            g2.drawLine(x1, y1, x2, y2);
         }
      }
      g2.setColor(Color.red);
      for (List<Point> pointList : listOfLists) {
         if (pointList.size() > 1) {
            for (int i = 1; i < pointList.size(); i++) {
               int x1 = pointList.get(i - 1).x;
               int y1 = pointList.get(i - 1).y;
               int x2 = pointList.get(i).x;
               int y2 = pointList.get(i).y;
               g2.drawLine(x1, y1, x2, y2);
            }
         }
      }
   }

   @Override
   public void mousePressed(Point p) {
      currentPoints = new ArrayList<Point>();
      currentPoints.add(p);
      repaint();
   }

   @Override
   public void mouseDragged(Point p) {
      currentPoints.add(p);
      repaint();
   }

   @Override
   public void mouseReleased(Point p) {
      if (currentPoints != null) {
         currentPoints.add(p);
         listOfLists.add(currentPoints);
      }
      currentPoints = null;
      repaint();
   }

}

class MyMouseAdapter extends MouseAdapter {
   @Override
   public void mouseDragged(MouseEvent mEvt) {
      Positionable positionable = (Positionable) mEvt.getSource();
      positionable.mouseDragged(mEvt.getPoint());
   }

   @Override
   public void mousePressed(MouseEvent mEvt) {
      Positionable positionable = (Positionable) mEvt.getSource();
      positionable.mousePressed(mEvt.getPoint());
   }

   @Override
   public void mouseReleased(MouseEvent mEvt) {
      Positionable positionable = (Positionable) mEvt.getSource();
      positionable.mouseReleased(mEvt.getPoint());
   }
}

interface Positionable {
   void mouseDragged(Point p);

   void mousePressed(Point p);

   void mouseReleased(Point p);
}