@Override
public boolean dispatchKeyEvent(KeyEvent event) {
    int keyCode = event.getKeyCode();
    switch (keyCode) {
    case KeyEvent.KEYCODE_VOLUME_UP:
    case KeyEvent.KEYCODE_VOLUME_DOWN:
        return true;
    default:
        return super.dispatchKeyEvent(event);
    }
}