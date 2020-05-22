@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    switch (keyCode) {
        case KeyEvent.KEYCODE_VOLUME_UP: {
            System.out.println("UP");
        }
        case KeyEvent.KEYCODE_VOLUME_DOWN: {
            System.out.println("DOWN");
        }
    }
    return super.onKeyDown(keyCode, event);
}