public boolean onKeyDown(int keyCode, KeyEvent event) {
    switch (keyCode) {
    case KeyEvent.KEYCODE_DPAD_CENTER:
        Toast.makeText(this, "The Center key was pressed",
                Toast.LENGTH_SHORT).show();
        return true;

    case KeyEvent.KEYCODE_DPAD_RIGHT:
        Toast.makeText(this, "The Right key was pressed",
                Toast.LENGTH_SHORT).show();
        return true;

    case KeyEvent.KEYCODE_DPAD_LEFT:
        Toast.makeText(this, "The Left key was pressed", Toast.LENGTH_SHORT)
                .show();
        return true;

    case KeyEvent.KEYCODE_BACK:
        Toast.makeText(this, "The Back key was pressed", Toast.LENGTH_SHORT)
                .show();

        //---this event has been handled---
        return true;
    }

    //---this event has not been handled---
    return false;
}