import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.*;

public class SimonGui {
   private static void createAndShowGui() {
      final SimonPanel simonPanel = new SimonPanel(600, 600, 1000);

      // create a list or random directions, just to test the GUI
      Random random = new Random();
      final List<Direction> dirList = new ArrayList<>();
      for (int i = 0; i < 15; i++) {
         int randomDirIndex = random.nextInt(Direction.values().length);
         Direction randomDir = Direction.values()[randomDirIndex];
         dirList.add(randomDir);
      }          

      JFrame frame = new JFrame("SimonGui");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(simonPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      // display the colors from the random list of directions, 
      // but wait 400 msecs to allow time for the GUI to display
      new Timer(400, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // have JPanel display the colors in the list
            simonPanel.displayDirectionList(dirList);

            // then stop this timer (timer should run just once)
            ((Timer) e.getSource()).stop();
         }
      }).start();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

@SuppressWarnings("serial")
class SimonPanel extends JPanel {
   private static final int GAP = 10;
   private int displayColorDelay;
   private int prefW;
   private int prefH;
   private Map<Direction, Shape> dirShapeMap = new LinkedHashMap<>();
   private Direction activeDir = null;
   private Timer displayColorTimer;

   public SimonPanel(int prefW, int prefH, int displayColorDelay) {
      this.prefW = prefW;
      this.prefH = prefH;
      this.displayColorDelay = displayColorDelay;

      int x = GAP;
      int y = GAP;
      int width = prefW - 2 * GAP;
      int height = prefH - 2 * GAP;
      int degree = 45;
      for (Direction direction : Direction.values()) {
         Shape shape = new Arc2D.Double(x, y, width, height, degree, 90, Arc2D.PIE);
         dirShapeMap.put(direction, shape);
         degree += 90;
      }

      setKeyBindings();
   }

   public void displayDirectionList(List<Direction> dirList) {
      displayColorTimer = new Timer(displayColorDelay, new DisplayColorTimerListener(dirList));
      displayColorTimer.start();
   }

   private void setKeyBindings() {
      Map<Direction, Integer> dirToKeyMap = new HashMap<>();
      dirToKeyMap.put(Direction.NORTH, KeyEvent.VK_UP);
      dirToKeyMap.put(Direction.WEST, KeyEvent.VK_LEFT);
      dirToKeyMap.put(Direction.SOUTH, KeyEvent.VK_DOWN);
      dirToKeyMap.put(Direction.EAST, KeyEvent.VK_RIGHT);

      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      for (Direction dir : Direction.values()) {
         int keyCode = dirToKeyMap.get(dir);
         boolean keyReleased = false; // key pressed
         KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(keyCode, 0, keyReleased);
         inputMap.put(pressedKeyStroke, pressedKeyStroke.toString());
         actionMap.put(pressedKeyStroke.toString(), new KeyBindingAction(dir, keyReleased));

         keyReleased = true; // key released
         KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(keyCode, 0, keyReleased);
         inputMap.put(releasedKeyStroke, releasedKeyStroke.toString());
         actionMap.put(releasedKeyStroke.toString(), new KeyBindingAction(dir, keyReleased));
      }

   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(prefW, prefH);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      for (Direction direction : dirShapeMap.keySet()) {
         Color color = (activeDir == direction) ? direction.getActiveColor() : direction.getPassiveColor();
         g2.setColor(color);
         g2.fill(dirShapeMap.get(direction));
      }
   }

   private class KeyBindingAction extends AbstractAction {
      private Direction dir;
      private boolean keyReleased;

      public KeyBindingAction(Direction dir, boolean keyReleased) {
         this.dir = dir;
         this.keyReleased = keyReleased;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO: action depending on direction and if key is pressed or released
      }
   }

   private class TurnOffListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         activeDir = null;
         repaint();
      }
   }

   private class DisplayColorTimerListener implements ActionListener {
      private List<Direction> directionList;
      private int counter = 0;
      private Timer turnOffTimer;

      public DisplayColorTimerListener(List<Direction> directionList) {
         this.directionList = directionList;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Timer timer = (Timer) e.getSource();
         if (counter == directionList.size()) {
            activeDir = null;
            timer.stop();
         } else {
            activeDir = directionList.get(counter);
            counter++;

            // so there's a time gap in the display, so that same colors will 
            // be distinct
            int turnOffDelay = (3 * timer.getDelay()) / 4; // turn off 3/4 time into display
            turnOffTimer = new Timer(turnOffDelay, new TurnOffListener());
            turnOffTimer.setRepeats(false);
            turnOffTimer.start();
         }
         repaint();         
      }
   }
}

enum Direction {
   NORTH(Color.blue),
   WEST(Color.yellow),
   SOUTH(Color.red),
   EAST(Color.green);

   private Color color;

   private Direction(Color color) {
      this.color = color;
   }

   public Color getColor() {
      return color;
   }

   public Color getPassiveColor() {
      return color.darker();
   }

   public Color getActiveColor() {
      return color.brighter();
   }

}