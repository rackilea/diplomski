@Override
public boolean dispatchKeyEvent(KeyEvent event) {
    if(KeyEvent.KEYCODE_MENU == event.getKeyCode() || KeyEvent.KEYCODE_DPAD_LEFT==event.getKeyCode()
            || KeyEvent.KEYCODE_DPAD_DOWN==event.getKeyCode() || KeyEvent.KEYCODE_DPAD_RIGHT==event.getKeyCode()
            || KeyEvent.KEYCODE_DPAD_UP==event.getKeyCode() || KeyEvent.KEYCODE_DPAD_CENTER==event.getKeyCode())
    {
        return false;
    }else if(KeyEvent.KEYCODE_BACK==event.getKeyCode()){
        //Do your task here...
    }
    return true;
}