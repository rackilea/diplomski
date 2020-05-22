import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main2 extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final int OVAL_W = 15;
   private int x = 150;
   private int y = 150;
   private JMenuBar menuBar;
   private JMenu file;
   private JMenuItem newGame;
   private JMenuItem checkScore;
   private JMenuItem exitGame;
   private Font font = new Font("Arial", Font.ITALIC, 30);

   public Main2() {      
      menuBar = new JMenuBar();
      file = new JMenu("File");
      newGame = new JMenuItem("New Game");
      checkScore = new JMenuItem("Check High Scores");
      exitGame = new JMenuItem("Close Game");

      menuBar.add(file);
      file.add(newGame);
      file.add(checkScore);
      file.addSeparator();
      file.add(exitGame);

      addKeyBinding();
   }

   public JMenuBar getMenuBar() {
      return menuBar;
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
      g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      g.setFont(font);
      g.drawString("Hello World", 100, 200);

      g.setColor(Color.red);
      g.drawOval(x, y, OVAL_W, OVAL_W);
      g.fillOval(x, y, OVAL_W, OVAL_W);
   }

   private void addKeyBinding() {
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      for (final MyDirection dir : MyDirection.values()) {
         KeyStroke keyStroke = KeyStroke.getKeyStroke(dir.getKeyCode(), 0);
         inputMap.put(keyStroke, dir.toString());
         actionMap.put(dir.toString(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent evt) {
               int newX = x + dir.getxTrans();
               int newY = y + dir.getyTrans();

               newX = Math.min(newX, PREF_W - 2 * OVAL_W);
               newX = Math.max(newX, OVAL_W);
               newY = Math.min(newY, PREF_H - 2 * OVAL_W);
               newY = Math.max(newY, OVAL_W);

               x = newX;
               y = newY;
               repaint();
            }
         });
      }
   }

   enum MyDirection {
      UP(KeyEvent.VK_UP, 0, -5), DOWN(KeyEvent.VK_DOWN, 0, 5), 
      LEFT(KeyEvent.VK_LEFT, -5, 0), RIGHT(KeyEvent.VK_RIGHT, 5, 0);

      private int keyCode;
      private int xTrans;
      private int yTrans;

      private MyDirection(int keyCode, int xTrans, int yTrans) {
         this.keyCode = keyCode;
         this.xTrans = xTrans;
         this.yTrans = yTrans;
      }

      public int getKeyCode() {
         return keyCode;
      }

      public int getxTrans() {
         return xTrans;
      }

      public int getyTrans() {
         return yTrans;
      }


   }

   private static void createAndShowGui() {
      Main2 main = new Main2();

      JFrame frame = new JFrame("Main2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(main);
      frame.setJMenuBar(main.getMenuBar());
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