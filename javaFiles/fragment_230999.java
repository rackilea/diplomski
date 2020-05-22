import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class DrawChit extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private List<MyDrawable> drawables = new ArrayList<>();

   public DrawChit() {
      setBackground(Color.white);
   }

   public void addMyDrawable(MyDrawable myDrawable) {
      drawables.add(myDrawable);
      repaint();
   }

   @Override
   // make it bigger
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
      for (MyDrawable myDrawable : drawables) {
         myDrawable.draw(g2);
      }
   }

   public void clearAll() {
      drawables.clear();
      repaint();
   }

   private static void createAndShowGui() {
      final List<MyDrawable> myDrawables = new ArrayList<>();
      myDrawables.add(new MyDrawable(new Line2D.Double(100, 40, 400, 400),
            Color.red, new BasicStroke(40)));
      myDrawables.add(new MyDrawable(new Ellipse2D.Double(50, 10, 400, 400),
            Color.blue, new BasicStroke(18)));
      myDrawables.add(new MyDrawable(new Rectangle2D.Double(40, 200, 300, 300),
            Color.cyan, new BasicStroke(25)));
      myDrawables.add(new MyDrawable(new RoundRectangle2D.Double(75, 75, 490, 450, 40, 40),
            Color.green, new BasicStroke(12)));

      final DrawChit drawChit = new DrawChit();

      JFrame frame = new JFrame("DrawChit");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(drawChit);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      int timerDelay = 1000;
      new Timer(timerDelay, new ActionListener() {
         private int drawCount = 0;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (drawCount >= myDrawables.size()) {
               drawCount = 0;
               drawChit.clearAll();
            } else {
               drawChit.addMyDrawable(myDrawables.get(drawCount));
               drawCount++;
            }
         }
      }).start();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class MyDrawable {
   private Shape shape;
   private Color color;
   private Stroke stroke;

   public MyDrawable(Shape shape, Color color, Stroke stroke) {
      this.shape = shape;
      this.color = color;
      this.stroke = stroke;
   }

   public Shape getShape() {
      return shape;
   }

   public Color getColor() {
      return color;
   }

   public Stroke getStroke() {
      return stroke;
   }

   public void draw(Graphics2D g2) {
      Color oldColor = g2.getColor();
      Stroke oldStroke = g2.getStroke();

      g2.setColor(color);
      g2.setStroke(stroke);
      g2.draw(shape);

      g2.setColor(oldColor);
      g2.setStroke(oldStroke);
   }

   public void fill(Graphics2D g2) {
      Color oldColor = g2.getColor();
      Stroke oldStroke = g2.getStroke();

      g2.setColor(color);
      g2.setStroke(stroke);
      g2.fill(shape);

      g2.setColor(oldColor);
      g2.setStroke(oldStroke);
   }

}