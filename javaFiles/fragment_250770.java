import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.EnumMap;

import javax.swing.*;

@SuppressWarnings("serial")
public class Boxxy2 extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final int SQUARE_W = 20;
   private static final String PRESSED = "pressed";
   private static final String RELEASED = "released";
   public static final int MOVE_SCALE = 1;
   private static final int TIMER_DELAY = 5;
   private int squareX = 0;
   private int squareY = 0;
   private int squareW = SQUARE_W;
   private int squareH = SQUARE_W;
   private EnumMap<Direction, Boolean> dirMap = new EnumMap<>(Direction.class);

   public Boxxy2() {
      setupKeyBinding();
      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   private void setupKeyBinding() {
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inMap = getInputMap(condition);
      ActionMap actMap = getActionMap();

      // this uses an enum of Direction that holds ints for the arrow keys
      for (Direction direction : Direction.values()) {
         dirMap.put(direction, Boolean.FALSE);
         int key = direction.getKey();
         String name = direction.name();

         KeyStroke keyPressed = KeyStroke.getKeyStroke(key, 0, false);
         KeyStroke keyReleased = KeyStroke.getKeyStroke(key, 0, true);

         // add the key bindings for arrow key and shift-arrow key
         inMap.put(keyPressed, name + PRESSED);
         inMap.put(keyReleased, name + RELEASED);
         actMap.put(name + PRESSED, new MyKeyAction(this, direction, true));
         actMap.put(name + RELEASED, new MyKeyAction(this, direction, false));
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.RED);
      g.fillRect(squareX, squareY, squareW, squareH);
   }

   private static void createAndShowGui() {
      Boxxy2 mainPanel = new Boxxy2();

      JFrame frame = new JFrame("Boxxy2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         for (Direction dir : dirMap.keySet()) {
            if (dirMap.get(dir)) {
               squareX += MOVE_SCALE * dir.getRight();
               squareY += MOVE_SCALE * dir.getDown();
            }
         }
         repaint();
      }
   }

   public void setMovement(Direction direction, boolean keyPressed) {
      dirMap.put(direction, keyPressed);
   }
}

enum Direction {
   UP(KeyEvent.VK_UP, 0, -1), DOWN(KeyEvent.VK_DOWN, 0, 1), LEFT(KeyEvent.VK_LEFT, -1, 0), RIGHT(KeyEvent.VK_RIGHT, 1, 0);

   private int key;
   private int right;
   private int down;

   private Direction(int key, int right, int down) {
      this.key = key;
      this.right = right;
      this.down = down;
   }

   public int getKey() {
      return key;
   }

   public int getRight() {
      return right;
   }

   public int getDown() {
      return down;
   }

}

// Actions for the key binding
@SuppressWarnings("serial")
class MyKeyAction extends AbstractAction {
   private Boxxy2 boxxy2;
   private Direction direction;
   private boolean keyPressed;

   public MyKeyAction(Boxxy2 boxxy2, Direction direction, boolean keyPressed) {
      this.boxxy2 = boxxy2;
      this.direction = direction;
      this.keyPressed = keyPressed;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      boxxy2.setMovement(direction, keyPressed);
   }
}