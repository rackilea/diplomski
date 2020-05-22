import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class BlinkerEg extends JPanel {
   private static final int PREF_W = 450;
   private static final int PREF_H = PREF_W;
   private List<Circle> circles = new ArrayList<>();

   public BlinkerEg() {
      circles.add(new Circle(Color.red, 1000, 0, 0, 450, this));
      circles.add(new Circle(Color.black, 60, 0, 0, 450, this));
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
      for (Circle circle : circles) {
         circle.paint(g2);
      }
   }

   private static void createAndShowGui() {
      BlinkerEg mainPanel = new BlinkerEg();

      JFrame frame = new JFrame("BlinkerEg");
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

class Circle {
   private Color color;
   private int x, y;
   private int diam;
   private JComponent component;
   private boolean on = true;

   public Circle(Color color, int ms, int x, int y, int diam, JComponent component) {
      this.color = color;
      this.x = x;
      this.y = y;
      this.diam = diam;
      this.component = component;

      new Timer(ms, new TimerListener()).start();
   }

   public void paint(Graphics g) {
      if (on) {
         g.setColor(color);
         g.fillOval(x, y, diam, diam);
      }
   }

   public boolean isOn() {
      return on;
   }

   public void setOn(boolean on) {
      this.on = on;
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         setOn(!isOn());
         component.repaint();
      }
   }
}