import java.awt.event.*;
import javax.swing.*;

public class SwingTimerEg2 {
   private JFrame frame;
   private Grid2 grid = new Grid2(this);
   private JTextArea textarea = new JTextArea(20, 20);
   private int stepCount = 0;

   public SwingTimerEg2() {
      frame = new JFrame();

      textarea.setEditable(false);
      frame.add(new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      setUpKeyBinding();
   }

   void setUpKeyBinding() {
      final int timerDelay = 250;
      final Timer keyTimer = new Timer(timerDelay, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            grid.stepGame();
         }
      });
      JPanel component = (JPanel) frame.getContentPane();
      final int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      final String spaceDown = "space down";
      final String spaceUp = "space up";
      component.getInputMap(condition).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), spaceDown);
      component.getActionMap().put(spaceDown, (new AbstractAction() {
         public void actionPerformed(ActionEvent e) {
            keyTimer.start();
         }
      }));
      component.getInputMap(condition).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), spaceUp);
      component.getActionMap().put(spaceUp, (new AbstractAction() {
         public void actionPerformed(ActionEvent e) {
            keyTimer.stop();
         }
      }));

   }

   public void doSomething() {
      textarea.append(String.format("Zap %d!!!%n", stepCount));
      stepCount ++;
   }

   private static void createAndShowGui() {
      new SwingTimerEg2();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

}

class Grid2 {
   private SwingTimerEg2 stEg;

   public Grid2(SwingTimerEg2 stEg) {
      this.stEg = stEg;
   }

   void stepGame() {
      stEg.doSomething();
   }
}