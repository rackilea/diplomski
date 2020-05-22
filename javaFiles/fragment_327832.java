@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {

    // KEYCODE_F12 = 142
    if (keyCode == KeyEvent.KEYCODE_F12) {
        findViewById(R.id.button).performClick();
    }

    return super.onKeyDown(keyCode, event);
}