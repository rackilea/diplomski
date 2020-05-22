// Invoked when a key has been pressed.
public void keyPressed(KeyEvent e) {
    // Returns the integer code for the key on the keyboard and if
    // keyCode is equal to VK_WINDOWS)...
    if (e.getKeyCode() == KeyEvent.VK_WINDOWS) {
        // ...call the doIT method.
        doIT();
    }
}