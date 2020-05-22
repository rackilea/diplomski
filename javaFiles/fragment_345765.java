public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            handler.set(InputAction.UP);
        }
        if (key == KeyEvent.VK_S) {
            handler.set(InputAction.DOWN);
        }
        if (key == KeyEvent.VK_A) {
            handler.set(InputAction.LEFT);
        }
        if (key == KeyEvent.VK_D) {
            handler.set(InputAction.RIGHT);
        }
        if (key == KeyEvent.VK_E) {
            handler.set(InputAction.ROTATE);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            handler.remove(InputAction.UP);
        }
        if (key == KeyEvent.VK_S) {
            handler.remove(InputAction.DOWN);
        }
        if (key == KeyEvent.VK_A) {
            handler.remove(InputAction.LEFT);
        }
        if (key == KeyEvent.VK_D) {
            handler.remove(InputAction.RIGHT);
        }
        if (key == KeyEvent.VK_E) {
            handler.remove(InputAction.ROTATE);
        }
    }

}