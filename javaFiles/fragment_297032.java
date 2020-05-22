import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserPageTest {
  public static JMenuBar makeMenuBar() {
    JMenuBar bar = new JMenuBar();
    JMenu menu = new JMenu("Test");
    JMenuItem item = new JMenuItem(action);
    item.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_DELETE, InputEvent.CTRL_DOWN_MASK));
    menu.add(item);
    bar.add(menu);
    return bar;
  }
  public static Action action = new AbstractAction("UserPage?") {
    @Override public void actionPerformed(ActionEvent e) {
      System.out.println("UserPage Action");
    }
  };
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() { createAndShowGUI(); }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();

    String KEY = "UserPageAction";
    f.getRootPane().getActionMap().put(KEY, action);
    InputMap im = f.getRootPane().getInputMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), KEY);

    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setJMenuBar(makeMenuBar());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}