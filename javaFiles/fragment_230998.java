import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class DrawChit extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = PREF_W;
   private List<Shape> shapes = new ArrayList<>();

   public DrawChit() {
      setBackground(Color.white);
   }

   public void addShape(Shape shape) {
      shapes.add(shape);
      repaint();
   }

   @Override // make it bigger
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      for (Shape shape : shapes) {
         g2.draw(shape);
      }
   }

   private static void createAndShowGui() {
      DrawChit drawChit = new DrawChit();

      drawChit.addShape(new Line2D.Double(10, 10, 100, 100));
      drawChit.addShape(new Ellipse2D.Double(120, 120, 200, 200));

      JFrame frame = new JFrame("DrawChit");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(drawChit);
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