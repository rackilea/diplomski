import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyPolar extends JPanel {
   private static final int BI_W = 400;
   private static final int BI_H = BI_W;
   private static final int CTR_X = BI_W / 2;
   private static final int CTR_Y = BI_H / 2;
   private static final Color AXIS_COLOR = Color.black;
   private static final Color GRID_LINE_COLOR = Color.LIGHT_GRAY;
   private static final Color DRAWING_COLOR = Color.RED;
   private static final float AXIS_LINE_WIDTH = 4f;
   private static final double SCALE = BI_W / (2 * 1.25);
   private static final float GRID_LINE_WIDTH = 2f;
   private static final float DRAWING_WIDTH = 2f;
   private static final double DELTA_THETA = Math.PI / (2 * 360);
   private static final int TIMER_DELAY = 20;
   private BufferedImage axiImg;
   private List<Point> ptList = new ArrayList<>();
   private double theta = 0;  

   public MyPolar() {
      axiImg = createAxiImg();

      int x = xEquation(theta);
      int y = yEquation(theta);
      ptList.add(new Point(x, y));

      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   private int xEquation(double theta) {
      double r = 2 * Math.sin(4 * theta);     
      return (int) (SCALE * 0.5 * r * Math.cos(theta)) + CTR_X;
   }

   private int yEquation(double theta) {
      double r = 2 * Math.sin(4 * theta);     
      return (int) (SCALE * 0.5 * r * Math.sin(theta)) + CTR_Y;
   }

   private BufferedImage createAxiImg() {
      BufferedImage img = new BufferedImage(BI_W, BI_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(AXIS_COLOR);
      g2.setStroke(new BasicStroke(AXIS_LINE_WIDTH));
      int x1 = 0;
      int y1 = CTR_Y;
      int x2 = BI_W;
      int y2 = y1;
      g2.drawLine(x1, y1, x2, y2);

      x1 = CTR_X;
      y1 = 0;
      x2 = x1;
      y2 = BI_H;
      g2.drawLine(x1, y1, x2, y2);

      g2.setColor(GRID_LINE_COLOR);
      g2.setStroke(new BasicStroke(GRID_LINE_WIDTH));

      x1 = (int) (CTR_X - BI_H * 0.5 * Math.tan(Math.PI / 6));
      y1 = BI_H;
      x2 = (int) (CTR_X + BI_H * 0.5 * Math.tan(Math.PI / 6));
      y2 = 0;
      g2.drawLine(x1, y1, x2, y2);

      x1 = BI_W - x1;
      x2 = BI_W - x2;
      g2.drawLine(x1, y1, x2, y2);

      x1 = (int) (CTR_X - BI_H * 0.5 * Math.tan(Math.PI / 3));
      y1 = BI_H;
      x2 = (int) (CTR_X + BI_H * 0.5 * Math.tan(Math.PI / 3));
      y2 = 0;
      g2.drawLine(x1, y1, x2, y2);

      x1 = BI_W - x1;
      x2 = BI_W - x2;
      g2.drawLine(x1, y1, x2, y2);

      for (int i = 1; i < 4; i++) {
         int x = (int) (CTR_X - i * SCALE / 2.0);
         int y = x;
         int width = (int) (i * SCALE);
         int height = width;         
         g2.drawOval(x, y, width, height);
      }

      g2.dispose();
      return img;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      if (axiImg != null) {
         g2.drawImage(axiImg, 0, 0, null);
      }
      g2.setColor(DRAWING_COLOR);
      g2.setStroke(new BasicStroke(DRAWING_WIDTH));
      Point prev = null;
      for (Point point : ptList) {
         if (prev != null) {
            int x1 = prev.x;
            int y1 = prev.y;
            int x2 = point.x;
            int y2 = point.y;
            g2.drawLine(x1, y1, x2, y2);
         }
         prev = point;
      }

   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(BI_W, BI_H);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         theta += DELTA_THETA;
         if (theta > 2 * Math.PI) {
            ((Timer) e.getSource()).stop();
         } else {
            int x = xEquation(theta);
            int y = yEquation(theta);
            ptList.add(new Point(x, y));
         }
         repaint();
      }
   }

   private static void createAndShowGui() {
      MyPolar mainPanel = new MyPolar();

      JFrame frame = new JFrame("MyPolar");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setResizable(false);
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