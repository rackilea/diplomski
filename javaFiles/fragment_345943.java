public class KeyPressedChecker implements EventHandler<KeyEvent> {

    private boolean downPressed = false;

    @Override
    public void handle(KeyEvent ke) {
        if (ke.getEventType() == KeyEvent.KEY_PRESSED) {
            downPressed = true ;
        } else if (ke.getEventType() == KeyEvent.KEY_RELEASED) {
            downPressed = false ;
        }   
    }

    public boolean isDownPressed() {
        return downPressed;
    }

}