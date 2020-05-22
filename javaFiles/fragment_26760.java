public boolean onKeyUp(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_MENU) {
        if (event.getAction() == KeyEvent.ACTION_UP)
        {
            Log.d("onkeyup", "onkeyup");
            return true;
        }
    }
    return super.onKeyUp(keyCode, event);
}