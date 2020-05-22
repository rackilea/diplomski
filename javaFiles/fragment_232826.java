@Override
public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        getStateMachine().setState((byte) 1);
    } else if (e.getKeyCode() == KeyEvent.SOME_OTHER_KEY) {
        // Do some other stuff here...
    }
}