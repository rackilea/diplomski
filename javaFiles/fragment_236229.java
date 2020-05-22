import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game2 {

   private static final String UP = "up";

   public static void main(String[] args) {
      new Game2();
   }

   public Game2() {
      JFrame window = new JFrame("Press up-arrow key");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel canvas = new JPanel();
      canvas.setPreferredSize(new Dimension(400, 300));
      window.add(canvas);

      canvas.add(new JButton(new AbstractAction("Press space-bar") {
         public void actionPerformed(ActionEvent e) {
            System.out.println("Button or space-bar pressed");
         }
      }));
      ActionMap actionMap = canvas.getActionMap();
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = canvas.getInputMap(condition);

      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), UP);
      actionMap.put(UP, new UpAction());

      window.pack();
      window.setLocationRelativeTo(null);
      window.setVisible(true);
   }
}

@SuppressWarnings("serial")
class UpAction extends AbstractAction {
   @Override
   public void actionPerformed(ActionEvent arg0) {
      System.out.println("Up Arrow pressed!");
   }
}