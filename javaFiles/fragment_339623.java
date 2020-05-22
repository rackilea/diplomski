KeyListener kl = new KeyListener() {

    boolean controlPressed = false;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
            controlPressed = true;
            return;
        }

        if(controlPressed) {
            // CTRL is pressed, you can check here for other keys:
            if(e.getKeyCode() == KeyEvent.VK_A) {
                //CTRL + A was pressed
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
            controlPressed = false;
        }
    }
};