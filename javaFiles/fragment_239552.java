import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gui extends JFrame {

   private MyPanel p;
   private JSlider slider;

   Gui() {
      super("Draw program");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      p = new MyPanel();
      p.setBackground(Color.RED);
      slider = new JSlider(SwingConstants.HORIZONTAL, 0, MyPanel.GRAY_MAX_LENGTH, p.getGrayWidth());
      slider.setMajorTickSpacing(50);
      slider.setPaintTicks(true);
      add(p);
      add(slider, BorderLayout.SOUTH);
      slider.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            p.setGrayWidth(slider.getValue());
         }
      });
   }

   // so we can test our code
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            Gui gui = new Gui();
            gui.pack();
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
         }
      });
   }
}

// note that this class should not be named
// panel as class names should start with an upper-case letter
class MyPanel extends JPanel {
   // constants to avoid use of "magic" numbers
   public static final int GRAY_MAX_LENGTH = 300;
   private static final int RECT_HEIGHT = 25;
   private static final int GAP = 20;
   private static final int PREF_W = GRAY_MAX_LENGTH + 2 * GAP;
   private static final int PREF_H = RECT_HEIGHT + 2 * GAP;
   private int grayWidth = 50;

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.GRAY);
      g.fillRect(GAP, GAP, grayWidth, RECT_HEIGHT);
   }

   @Override // so our GUI is big enough
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   public void setGrayWidth(int width) {
      this.grayWidth = (width > 0) ? width : 0;
      repaint();
   }

   // ***** key is to change this method's name so you don't
   // override JPanel's getWidth() method
   public int getGrayWidth() {
      return grayWidth;
   }
}