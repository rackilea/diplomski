public class Appl extends Applet implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("Pressed: " + ke.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
          System.out.println("Pressed: " + ke.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
          System.out.println("Pressed: " + ke.getKeyChar());
    }



    public void init() {
        // YOUR CODE
        addKeyListener(this);
    }
}