public class KeyListenerExample extends GraphicsProgram {

    @Override
    public void run() {
        addKeyListeners(new MyKeyListener());
    }

    private class MyKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_P) {
                System.out.println("Key 'P' has been pressed!");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) { /* Empty body */ }

        @Override
        public void keyTyped(KeyEvent e) { /* Empty body */ }

    }
}