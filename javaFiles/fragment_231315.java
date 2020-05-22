import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw extends JComponent implements KeyListener {
   int x = 0;
   int y = 0;

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLUE);
      g.fillRect(x, y, 50, 50);
   }

   public void keyPressed(KeyEvent k) {
      if (k.getKeyCode() == KeyEvent.VK_UP) {
         y -= 2;
      } else if (k.getKeyCode() == KeyEvent.VK_DOWN) {
         y += 2;
      } else if (k.getKeyCode() == KeyEvent.VK_LEFT) {
         x -= 2;
      } else if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
         x += 2;
      }

      repaint();
   }

   public void keyReleased(KeyEvent k) {
   }

   public void keyTyped(KeyEvent k) {
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            Draw d = new Draw();
            JFrame f = new JFrame("Game");
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setSize(800, 600);
            f.setVisible(true);

            f.add(d);
            f.addKeyListener(d);
         }
      });
   }
}