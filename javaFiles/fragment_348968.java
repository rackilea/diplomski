@Override
public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    if (e2.getAction() == MotionEvent.ACTION_MOVE) {
        z++;
       if (z >= 120) {   // zero based arraylist, so, >= 120
           z = 0;
       }
       tv.invalidate; // this to redraw the point
    }
    return true;
}