@Override
public boolean dispatchKeyEvent(KeyEvent event) {

    System.out.println(event.getAction() + " " + event.getKeyCode() + " - " + (char) event.getUnicodeChar());

    return true;
}