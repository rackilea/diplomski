import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

class JavaPaintUI extends JFrame {
   private static final Color FILL_COLOR = Color.BLUE;
   private static final Color BORDER_COLOR = Color.RED;
   public static final Stroke STROKE = new BasicStroke(4f);

   private JPanel jPanel2;

   public JavaPaintUI() {
      initComponents();
   }

   private void initComponents() {
      jPanel2 = new Panel2();
      this.setContentPane(jPanel2);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
   }

   class Panel2 extends JPanel {
      private static final int TIMER_DELAY = 2000;
      private Random random = new Random();
      private List<Shape> shapeList = new ArrayList<>();

      Panel2() {
         setPreferredSize(new Dimension(420, 420));
         new Timer(TIMER_DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
               int width = random.nextInt(100);
               int height = random.nextInt(100);
               int x = random.nextInt(getWidth() - width);
               int y = random.nextInt(getHeight() - height);
               shapeList.add(new Rectangle(x, y, width, height));
               repaint();
            }
         }).start();
      }

      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawString("BLAH", 20, 20);
         Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setStroke(STROKE);
         for (Shape shape : shapeList) {
            g2.setColor(FILL_COLOR);
            g2.fill(shape);
            g2.setColor(BORDER_COLOR);
            g2.draw(shape);
         }
      }
   }

   public static void main(String args[]) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            new JavaPaintUI().setVisible(true);
         }
      });
   }
}