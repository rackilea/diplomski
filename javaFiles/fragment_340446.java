private long tsDown;

@Override
public boolean onTouchEvent(@NonNull MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
             ...
             tsDown = System.currentTimeMillis();
             break;
        case MotionEvent.ACTION_UP:
            ...
            if (!mMoveOutside) {
                long tsUp = System.currentTimeMillis();
                if (tsUp - tsDown < 1000){
                  // if press duration is below 1s                       
                  performClick();
                }else{
                  performLongClick();
                }  
            }
            break;

    }
    return true;
}