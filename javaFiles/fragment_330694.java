import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class DrawingComponent extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final Color RECT_COLOR = new Color(255,25,0);
   private Rectangle rect = new Rectangle(300, 100, 50, 50);

   public DrawingComponent() {
      setUpKeyBindings();
   }

   private void setUpKeyBindings() {
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      KeyStroke wStroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0);
      inputMap.put(wStroke, wStroke.toString());
      actionMap.put(wStroke.toString(), new WAction());
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(RECT_COLOR);
      g2.fill(rect);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class WAction extends AbstractAction {
      @Override
      public void actionPerformed(ActionEvent e) {
         rect.setLocation(rect.x-50, rect.y);
         repaint();
      }
   }

   private static void createAndShowGui() {
      DrawingComponent mainPanel = new DrawingComponent();

      JFrame frame = new JFrame("DrawingComponent");
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