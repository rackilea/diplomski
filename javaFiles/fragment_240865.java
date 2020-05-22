public class WindowsKey extends JPanel implements KeyEventDispatcher {
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_TYPED) {
            int code = e.getKeyChar();

            if (KeyEvent.VK_WINDOWS == code) {

                return true;
            }
        }
        return false;
    }
}