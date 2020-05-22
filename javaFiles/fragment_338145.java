public boolean onTouch(View v, MotionEvent event) {
     if (_gestureDetector.onTouchEvent(event)) {
         return true;
     }
     return false;
 }