@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
    if (ev.getAction() == MotionEvent.ACTION_DOWN) {
        getDialogs().clearAll();
        getDialogs().dimissSnackBar() ;
    }
    return super.dispatchTouchEvent(ev);
}