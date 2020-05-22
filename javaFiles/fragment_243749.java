protected boolean keyDown(int keycode, int time) {
    int key = Keypad.key(keycode);
    if (key == Characters.ESCAPE) {
        // do something here
        return true;
    }
    return super.keyDown(keycode, time);
}