import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class JTextFieldMagic {
   public static final String CTRL_ALT_BACK_SPACE = "ctrlAltBackspace";

   public static void main(String[] args) {
      JTextField field = new JTextField(10);

      int condition = JComponent.WHEN_FOCUSED;
      InputMap inputmap = field.getInputMap(condition);
      ActionMap actionMap = field.getActionMap();

      KeyStroke ctrlAltBackSpaceKeyStroke = KeyStroke.getKeyStroke(
            KeyEvent.VK_BACK_SPACE, 
            KeyEvent.CTRL_DOWN_MASK | KeyEvent.ALT_DOWN_MASK);

      inputmap.put(ctrlAltBackSpaceKeyStroke, CTRL_ALT_BACK_SPACE);
      actionMap.put(CTRL_ALT_BACK_SPACE, new CtrlAltBackspaceAction());

      JOptionPane.showMessageDialog(null, field);
   }
}

class CtrlAltBackspaceAction extends AbstractAction {
   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println(JTextFieldMagic.CTRL_ALT_BACK_SPACE);
   }
}