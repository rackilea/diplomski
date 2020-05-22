public class KeyManager implements KeyListener{
    private boolean spacePressed = false;

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(this.spacePressed == false){
                this.spacePressed = true;
                System.out.println("Hello world");
            }               
        }
    }