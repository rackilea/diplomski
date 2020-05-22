import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class DemoDialog {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Frame");
      frame.add(Box.createRigidArea(new Dimension(400, 300)));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      final JDialog dialog = new JDialog(frame, "Dialog", true);

      // set binding
      int condition = JPanel.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = ((JPanel) dialog.getContentPane()).getInputMap(condition);
      ActionMap actionMap = ((JPanel) dialog.getContentPane()).getActionMap();
      String enter = "enter";
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
      actionMap.put(enter, new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent e) {
            dialog.dispose();
         }
      });

      dialog.add(Box.createRigidArea(new Dimension(200, 200)));
      dialog.pack();
      dialog.setLocationRelativeTo(frame);
      dialog.setVisible(true);

   }
}