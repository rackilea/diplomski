@Override
public boolean dispatchTouchEvent(MotionEvent ev)
{
  super.dispatchTouchEvent(ev);
  return gestureScanner.onTouchEvent(ev);
}