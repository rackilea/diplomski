@Override
public boolean dispatchKeyEvent(KeyEvent event) {
    int action = event.getAction();
    int keyCode = event.getKeyCode();

    switch (keyCode) {
    case KeyEvent.KEYCODE_VOLUME_UP:
        if (action == KeyEvent.ACTION_UP) {
            //TODO
        }
        return true;
    case KeyEvent.KEYCODE_VOLUME_DOWN:
        if (action == KeyEvent.ACTION_DOWN) {
            //TODO
        }
        return true;
    default:
        return super.dispatchKeyEvent(event);
    }
}