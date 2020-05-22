public class MyKeyListener implements KeyListener {
    //class gets the input from the player
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Left")) {
            //left arrow key
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Right")) {
            //right arrow key
        }
    }
    public void keyReleased(KeyEvent e) {
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Left"){
            //left key released
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Right")) {
            //right key released
        }

    }
}