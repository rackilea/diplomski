// We assume your bridge class is already instantiated and called `bridge`
@Override
public boolean onKeyDown (int keyCode, KeyEvent event) {
    super.onKeyDown(keyCode, event);

    if (bridge.onKeyDown(keyCode, event)) {
        return true;
    }

    // User code for other keys here
}