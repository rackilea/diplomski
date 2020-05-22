import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyCtrl3 extends JFrame {

private class MyDispatcher implements KeyEventDispatcher {
    // usualy one prefer using keybindings - but we are in
    // special case for detect AltGr
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.isAltGraphDown()) {
                // uncaught in windows
                System.out.println("ALT GRAPH");
            } else if (e.isControlDown()) {
                // fired 1 by windows when press AltGr
                System.out.println("CONTROL");
                // here I launch a timer, 1ms delay is enough 
                // to wait for ALT key if coming
            } else if (e.isAltDown()) {
                // fired 2 by windows when press AltGr
                // here I unarm the timer
                System.out.println("ALT");
            }
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (e.getKeyCode() == KeyEvent.VK_ALT_GRAPH) {
                System.out.println("ALT GRAPH released");
            } else if (e.getKeyCode() == KeyEvent.VK_ALT) {
                System.out.println("ALT released");
            } else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                System.out.println("CONTROL released");
            }
        }
        return false;
    }
}

public MyCtrl3() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(200, 100));
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    manager.addKeyEventDispatcher(new MyDispatcher());
}

public static void main(String[] a) {
    MyCtrl3 myProjet = new MyCtrl3();
    myProjet.pack();
    myProjet.setVisible(true);
}
}