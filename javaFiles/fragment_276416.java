@Override
public boolean dispatchKeyEvent(KeyEvent event) {
    if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
        if (event.getAction() == KeyEvent.ACTION_UP){

         enter();

            return true;
    }}
    return super.dispatchKeyEvent(event);
};