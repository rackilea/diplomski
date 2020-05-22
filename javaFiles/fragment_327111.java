import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.*;
import java.util.EnumMap;
import javax.swing.*;

@SuppressWarnings("serial")
public class KeyBindingPanel extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = PREF_W;
   private static final Stroke THICK_STROKE = new BasicStroke(5f,
         BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
   private static final int OVAL_WIDTH = 30;
   private static final int OVAL_HEIGHT = 30;
   private static final Color OVAL_COLOR = Color.red;
   private static final Color BKGRD_COLOR = Color.black;
   private static final int TIMER_DELAY = 20;
   public static final int STEP = 2;
   private int myX = 0;
   private int myY = 0;
   private JButton[] buttons = new JButton[3];
   private int condition = WHEN_IN_FOCUSED_WINDOW;
   private InputMap inputMap = getInputMap(condition);
   private ActionMap actionMap = getActionMap();
   private EnumMap<Direction, Boolean> directionMap = new EnumMap<Direction, Boolean>(
         Direction.class);

   public KeyBindingPanel() {
      for (int i = 0; i < buttons.length; i++) {
         buttons[i] = new JButton(new ButtonAction());
         add(buttons[i]);
      }
      setBackground(BKGRD_COLOR);

      for (final Direction direction : Direction.values()) {
         directionMap.put(direction, Boolean.FALSE);

         Boolean[] onKeyReleases = { Boolean.TRUE, Boolean.FALSE };
         for (Boolean onKeyRelease : onKeyReleases) {
            KeyStroke keyStroke = KeyStroke.getKeyStroke(
                  direction.getKeyCode(), 0, onKeyRelease);
            inputMap.put(keyStroke, keyStroke.toString());
            actionMap.put(keyStroke.toString(), new DirAction(direction,
                  onKeyRelease));
         }
      }

      new Timer(TIMER_DELAY, new GameTimerListener()).start();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2b = (Graphics2D) g.create();
      g2b.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2b.setStroke(THICK_STROKE);
      g2b.setColor(OVAL_COLOR);
      g2b.drawOval(myX, myY, OVAL_WIDTH, OVAL_HEIGHT);

      g2b.dispose(); // since I created this guy
   }

   private class GameTimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         for (Direction direction : Direction.values()) {
            if (directionMap.get(direction)) {
               myX += STEP * direction.getRight();
               myY += STEP * direction.getDown();
            }
         }
         repaint();
      }
   }

   private class DirAction extends AbstractAction {
      private Direction direction;
      private boolean onRelease;

      public DirAction(Direction direction, boolean onRelease) {
         this.direction = direction;
         this.onRelease = onRelease;
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         directionMap.put(direction, !onRelease); // it's the opposite!
      }
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction() {
         super("Press Me!");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         JButton thisBtn = (JButton) e.getSource();
         for (JButton btn : buttons) {
            if (btn == thisBtn) {
               btn.setEnabled(false);
            } else {
               btn.setEnabled(true);
            }
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("KeyBindingPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new KeyBindingPanel());
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

enum Direction {
   UP(KeyEvent.VK_UP, -1, 0), DOWN(KeyEvent.VK_DOWN, 1, 0), LEFT(
         KeyEvent.VK_LEFT, 0, -1), RIGHT(KeyEvent.VK_RIGHT, 0, 1);

   private int keyCode;
   private int down;
   private int right;

   private Direction(int keyCode, int down, int right) {
      this.keyCode = keyCode;
      this.down = down;
      this.right = right;
   }

   public int getKeyCode() {
      return keyCode;
   }

   public int getDown() {
      return down;
   }

   public int getRight() {
      return right;
   }

}