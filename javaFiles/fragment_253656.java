@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
        return true;
    }
    else
        return super.onKeyDown(keyCode, event);
}