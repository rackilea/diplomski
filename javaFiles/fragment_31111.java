fxPanel.addKeyListener(new KeyListener() {

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 10) {
            e.setKeyChar((char) 13);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(e);
        }
    }

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}
});