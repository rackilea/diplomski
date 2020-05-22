public class KeyHandler extends KeyAdapter {

    private InputHandler inputHandler;

    public KeyHandler(InputHandler handler) {
        this.inputHandler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            inputHandler.add(Input.LEFT);
        } else if (key == KeyEvent.VK_RIGHT) {
            inputHandler.add(Input.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            inputHandler.remove(Input.LEFT);
        } else if (key == KeyEvent.VK_RIGHT) {
            inputHandler.remove(Input.RIGHT);
        }
    }
}