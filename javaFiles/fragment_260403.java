public class YourView extends View implements View.OnTouchListener {

@Override
public boolean onTouch(View v, MotionEvent event) {
    //Here you can check for which movement is being made on a switch pattern. 
    //You can also call any gesture detector you might have

      mScaleDetector.onTouchEvent(event);
      mRotationDetector.onTouchEvent(event);
      mGestureDetector.onTouchEvent(event);

      final int action = MotionEventCompat.getActionMasked(ev);
      switch (action) {
        case MotionEvent.ACTION_DOWN:
        //Do stuff;
        break;
        case MotionEvent.ACTION_MOVE:
        //Do stuff;
        break;
        case MotionEvent.ACTION_UP:
        //Do stuff;
        break;
    return false;
    } 
}