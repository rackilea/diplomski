import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;    
import javax.swing.*;

public class BalanceChart {

   Double[] Props = new Double[6];

   public static void main(String[] args) {
      JFrame f = new JFrame("Balance Chart");
      //  f.setSize(500, 500);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ChartComponent ccOne = new ChartComponent(50, 50, 100, 200);
      ChartComponent ccTwo = new ChartComponent(10, 10, 10, 10);
      JPanel container = new JPanel();
      container.add(ccOne);
      container.add(ccTwo);
      f.add(container);
      f.pack();
      f.setLocationByPlatform(true);
      f.setVisible(true);
   }

   private void getProps() {
      // ignore
   }

}

class ChartComponent extends JComponent {

   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private int x, y, w, h;

   public ChartComponent(int x, int y, int w, int h) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setColor(Color.RED);
      g2.fillRect(w, h, x, y);
      g2.dispose();
   }

}