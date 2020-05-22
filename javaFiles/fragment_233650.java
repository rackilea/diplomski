@Override
public boolean onKey(View view, int i, KeyEvent keyEvent) {
    if (null != keyEvent && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

        if (System.currentTimeMillis() - mLastClickedTime > DEFAULT_PRESSED_DELAY) {
            Log.d(TAG, "onKey: single  presed");
            onKeyPressed(view, keyEvent);

        } else {
            Log.d(TAG, "onKey: repeat pressed");
            onKeyRepeatPressed(view);

        }
        mLastClickedTime=System.currentTimeMillis();

    }
    return false;
}