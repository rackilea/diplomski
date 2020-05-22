addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_F11 && event.isAltDown()) {
            dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }      
});