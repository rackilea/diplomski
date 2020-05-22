private boolean hasLetter = false;
private boolean hasDigit = false;

public void keyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            // OK
            hasLetter = true;
        } else if (Character.isDigit(c)) {
            // OK
            hasDigit = true;                
        } else {
            // Ignore this character
            evt.consume();
        }
}