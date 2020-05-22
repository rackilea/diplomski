import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawRect extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = PREF_W;
   private static final int DELTA = 50;
   private static final Color RECT_COLOR = Color.red;
   private static final int RECT_WIDTH = 100;
   private static final int TIMER_DELAY = 15;
   private int rectX = PREF_W - DELTA;
   private int rectY = PREF_H - DELTA;

   public DrawRect() {
      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(RECT_COLOR);
      g.fillRect(rectX, rectY, RECT_WIDTH, RECT_WIDTH);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         rectX--;
         rectY--;
         repaint();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("DrawRect");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new DrawRect());
      frame.pack();
      frame.setLocationRelativeTo(null);
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