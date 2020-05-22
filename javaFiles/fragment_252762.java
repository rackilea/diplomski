@Override
public boolean onTouchEvent(MotionEvent event) {

  // this = EditText;
  // will give you the position of the nearest chracter.    
  int offset = this.getOffsetForPosition(event.getX(), event.getY());