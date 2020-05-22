import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MyAnimationTest extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final Color BG = Color.RED;
   private static final int TIMER_DELAY = 15;
   public static final int X_STEP = 5;
   private MyPlayer player = new MyPlayer(PREF_W / 2, PREF_H / 4);
   private boolean right = false;
   private Timer timer = new Timer(TIMER_DELAY, new TimerListener());

   public MyAnimationTest() {
      setBackground(BG);
      setUpKeyBindings();
      timer.start();
   }

   private void setUpKeyBindings() {
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inMap = getInputMap(condition);
      ActionMap actMap = getActionMap();

      KeyStroke rightArrowDownStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false);
      KeyStroke rightArrowUpStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true);

      inMap.put(rightArrowDownStroke, rightArrowDownStroke.toString());
      inMap.put(rightArrowUpStroke, rightArrowUpStroke.toString());

      actMap.put(rightArrowDownStroke.toString(), new RightMoveAction(true));
      actMap.put(rightArrowUpStroke.toString(), new RightMoveAction(false));
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      player.draw(g);
   }

   private class RightMoveAction extends AbstractAction {
      private boolean move;

      public RightMoveAction(boolean move) {
         this.move = move;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         right = move;
      }
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if (right) {
            int newX = player.getX() + X_STEP;
            player.setX(newX);
            repaint();
         }
      }
   }

   private static void createAndShowGui() {
      MyAnimationTest mainPanel = new MyAnimationTest();

      JFrame frame = new JFrame("My Animation");
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

/**
 * A logical class that does not extend a Swing component
 * 
 * @author Pete
 *
 */
class MyPlayer {
   public static final Color COLOR = Color.blue;
   public static final int WIDTH = 30;
   private BufferedImage sprite = new BufferedImage(WIDTH, WIDTH, BufferedImage.TYPE_INT_ARGB);
   private int x;
   private int y;

   public MyPlayer(int x, int y) {
      this.x = x;
      this.y = y;

      Graphics g = sprite.getGraphics();
      g.setColor(COLOR);
      g.fillRect(0, 0, WIDTH, WIDTH);
      g.dispose();
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   public void draw(Graphics g) {
      g.drawImage(sprite, x, y, null);
   }
}