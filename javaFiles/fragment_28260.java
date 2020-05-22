public boolean onTouch(MotionEvent ev) {
     final int pointerCount = ev.getPointerCount();
     for (int p = 0; p < pointerCount; p++) {
         onTouch(ev.getPointerId(p), ev.getAction(), ev.getX(p), ev.getY(p));
     }
     return true;
 }