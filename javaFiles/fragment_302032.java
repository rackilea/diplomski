import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyBetterStillCanvas extends JComponent {
   private static final int PREF_W = 500;
   private static final int PREF_H = 500;
   private static final int OVAL_X = 10;
   private static final int OVAL_Y = OVAL_X;
   private static final Paint BG_PAINT = new GradientPaint(0, 20,
         Color.black, 20, 0, Color.darkGray, true);

   private static final Paint FILL_PAINT = new GradientPaint(0, 0,
         Color.blue, 20, 20, Color.red, true);

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      // to smooth out graphics
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      // let's draw something funky

      g2.setPaint(BG_PAINT);
      g2.fillRect(0, 0, getWidth(), getHeight());

      g2.setPaint(FILL_PAINT);
      // avoid use of "magic" numbers
      g.fillOval(OVAL_X, OVAL_Y, getWidth() - 2 * OVAL_X, getHeight() - 2
            * OVAL_Y);
   }

   // a cleaner way to set the preferred size of a component
   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void main(String[] a) {
      JFrame window = new JFrame("My Better Canvas");
      window.getContentPane().add(new MyBetterStillCanvas());
      window.setLocationByPlatform(true);
      window.pack();
      window.setVisible(true);
   }
}