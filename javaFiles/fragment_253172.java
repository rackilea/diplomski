import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class TestShowGraph {
   private static final int MAX_POINTS = 30;
   private static final int TIMER_DELAY = 800;

   private static void createAndShowGui() {
      ShowGraph showGraphPanel = new ShowGraph(MAX_POINTS);
      TimerListener timerListener = new TimerListener(MAX_POINTS, showGraphPanel);

      JFrame frame = new JFrame("TestShowGraph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(showGraphPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      new Timer(TIMER_DELAY, timerListener).start();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }  
}

class TimerListener implements ActionListener {
   private static final double EXP_MULTIPLIER = 0.2;

   // array of points created in constructor to hold data that
   // will eventually be displayed in real time.
   // A Swing Timer will copy a point into the pointsList above. 
   private Point2D[] initPoints;

   private int maxPoints;
   private int count = 0;
   private ShowGraph showGraph;

   public TimerListener(int maxPoints, ShowGraph showGraph) {
      initPoints = new Point2D[maxPoints];
      this.maxPoints = maxPoints;
      this.showGraph = showGraph;

      // create all data points that will eventually be 
      // graphed. This is to simulate real-time data collection
      for (int i = 0; i < initPoints.length; i++) {
         double x = (double) i / initPoints.length;
         double y = 1.0 - Math.exp(-1.0 * i * EXP_MULTIPLIER);        
         initPoints[i] = new Point2D.Double(x, y);
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (count < maxPoints) {
         // simply push data from initPoints into the list that will
         // be used to draw the graph
         showGraph.addPoint(initPoints[count]);
         count++;
      } else {
         // unless we've run out of points. Then simply start over
         count = 0;
         showGraph.clearPointsList();
      }

      // repaint so that the GUI will show the points
      showGraph.repaint();
   }
}

@SuppressWarnings("serial")
class ShowGraph extends JPanel {

   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final int BORDER_GAP = 50;
   private static final Color AXIS_COLOR = Color.blue;
   private static final Color POINTS_COLOR = Color.red;
   private static final Color BACKGRND_COLOR = Color.white;
   private static final Stroke AXIS_STROKE = new BasicStroke(3f);
   private static final Stroke POINTS_STROKE = new BasicStroke(2f);
   private static final double X_SCALE = PREF_W - 2 * BORDER_GAP;
   private static final double Y_SCALE = PREF_H - 2 * BORDER_GAP;
   private static final int POINT_RADIUS = 3;

   // list that the paintComponent method loops through to
   // draw points
   private List<Point2D> pointsList = new ArrayList<Point2D>();


   public ShowGraph(int maxPoints) {
      setBackground(BACKGRND_COLOR);
   }

   public void addPoint(Point2D point2d) {
      pointsList.add(point2d);
   }

   public void clearPointsList() {
      pointsList.clear();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
      drawAxises(g2);
      drawPoints(g2);
   }

   private void drawAxises(Graphics g2) {
      // derive a Graphics2D object from the one provided by the 
      // JVM so we can change settings on it without effecting 
      // the Graphics object provided by the JVM
      Graphics2D g2Axises = (Graphics2D) g2.create();
      g2Axises.setStroke(AXIS_STROKE);
      g2Axises.setColor(AXIS_COLOR);
      int x1XAxis = BORDER_GAP;
      int y1XAxis = PREF_H - BORDER_GAP;
      int x2XAxis = PREF_W - BORDER_GAP;
      int y2XAxis = PREF_H - BORDER_GAP;
      g2Axises.drawLine(x1XAxis, y1XAxis, x2XAxis, y2XAxis);
      int x1YAxis = BORDER_GAP;
      int y1YAxis = BORDER_GAP;
      int x2YAxis = BORDER_GAP;
      int y2YAxis = PREF_H - BORDER_GAP;
      g2Axises.drawLine(x1YAxis, y1YAxis, x2YAxis, y2YAxis);
      g2Axises.dispose(); // because we derived this we must dispose it
   }

   private void drawPoints(Graphics2D g2) {
      Graphics2D g2Points = (Graphics2D) g2.create();
      g2Points.setStroke(POINTS_STROKE);
      g2Points.setColor(POINTS_COLOR); 

      for (Point2D p : pointsList) {
         // p points hold data between 0 and 1
         // we must scale our points to fit the display
         // before displaying them
         int pX = (int)(X_SCALE * p.getX()) + BORDER_GAP;
         int pY = PREF_H - (int)(Y_SCALE * p.getY()) - BORDER_GAP;

         // displayed the scaled points
         int radius = POINT_RADIUS;
         g2Points.drawOval(pX - radius, pY - radius, 2 * radius, 2 * radius);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

}