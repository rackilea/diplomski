@Override
public boolean onTouchEvent(MotionEvent ev) {
    if (ev.getAction() == MotionEvent.ACTION_DOWN) {
        // record the start time, start the timer
        mEventStartTime = ev.getEventTime();
        mHandler.postDelayed(mTask, LONG_PRESS_TIME);
    } else if (ev.getAction() == MotionEvent.ACTION_UP) {
        // record the end time, dont show if not long enough
        mEventEndTime = ev.getEventTime();
        if (mEventEndTime - mEventStartTime < LONG_PRESS_TIME) {
            mHandler.removeCallbacks(mTask);        
        }
    } else {
        // moving, panning, etc .. up to you whether you want to
        // count this as a long press - reset timing to start from now
                    mEventStartTime = ev.getEventTime();
        mHandler.removeCallbacks(mTask);
                    mHandler.postDelayed(mTask, LONG_PRESS_TIME);
    }

    return super.onTouchEvent(ev);
}