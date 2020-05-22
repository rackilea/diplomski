@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if(keyCode == KeyEvent.KEYCODE_MENU) {
        openOptionsMenu();
        return true;
    }
    return super.onKeyDown(keyCode, event);
}