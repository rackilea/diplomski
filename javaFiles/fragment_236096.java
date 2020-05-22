@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
    Rect dialogBounds = new Rect();
    getWindow().getDecorView().getHitRect(dialogBounds);

    if (!dialogBounds.contains((int) ev.getX(), (int) ev.getY())) {
        // Tapped outside so we finish the activity
        this.finish();
    }
    return super.dispatchTouchEvent(ev);
}