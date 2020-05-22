private boolean mIsScreenTouched;

public boolean onTouch(View v, MotionEvent event) {

    switch (event.getAction()){
    case MotionEvent.ACTION_DOWN :
    case MotionEvent.ACTION_MOVE :
        mIsScreenTouched = true; 
        break; 
    case MotionEvent.ACTION_CANCEL :    
    case MotionEvent.ACTION_UP :
        mIsScreenTouched = false; 
        break; 
    }

    return true;
}