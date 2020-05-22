import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
public class KeyStrokeSampleVKF4Shift {
  public static void main(String[] a) {
    String ACTION_KEY = "theAction";
    JFrame frame = new JFrame("KeyStroke Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton buttonA = new JButton("<html><center>ANCESTOR<br>VK_F4+SHIFT_MASK");
    Action actionListener = new AbstractAction() {
      public void actionPerformed(ActionEvent actionEvent) {
        JButton source = (JButton) actionEvent.getSource();
        System.out.println(source.getText());
      }
    };
    KeyStroke shiftF4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.SHIFT_MASK);
    InputMap inputMap = buttonA.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    inputMap.put(shiftF4, ACTION_KEY);
    ActionMap actionMap = buttonA.getActionMap();
    actionMap.put(ACTION_KEY, actionListener);
    buttonA.setActionMap(actionMap);
    frame.add(buttonA);
    frame.setSize(400, 200);
    frame.setVisible(true);
  }
}