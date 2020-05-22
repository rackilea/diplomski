case MotionEvent.ACTION_MOVE: {
    if (mIsBeingDragged) {
        mLastMotionY = event.getY();
        mLastMotionX = event.getX();
        pullEvent();
        return true;
    }
    else if (isReadyForPull()) {
        final float y = event.getY(), x = event.getX();
        final float diff, oppositeDiff, absDiff;
        diff = y - mLastMotionY;
        oppositeDiff = x - mLastMotionX;
        absDiff = Math.abs(diff);
        ViewConfiguration config = ViewConfiguration.get(getContext());

        if (absDiff > config.getScaledTouchSlop() &&  absDiff > 
        Math.abs(oppositeDiff) && diff >= 1f) {
             mLastMotionY = y;
             mLastMotionX = x;
             mIsBeingDragged = true;
        }
     }
     break;
 }