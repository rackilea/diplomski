public boolean shiftPressed;

public void keyPressed(KeyEvent e) {
    if(shiftPressed && e.getKeyCode() == VK_(a letter)) {
        //Execute some code
    }
    else if(e.getKeyCode() == VK_SHIFT) {
        shiftPressed = true;
    }
}

public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == VK_SHIFT) {
        shiftPressed = false;
    }
}