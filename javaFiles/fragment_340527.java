public boolean onTouchEvent(MotionEvent event)
{
    synchronized (getHolder())
    {   
        int aktion = event.getAction();
        if (aktion == MotionEvent.ACTION_DOWN || aktion == MotionEvent.ACTION_POINTER_DOWN
        || aktion == MotionEvent.ACTION_UP || aktion == MotionEvent.ACTION_POINTER_UP)
        {
            bar.clearTouches();
            for (int i = 0; i < event.getPointerCount(); i++) {
                bar.shareTouch(event.getX(i)); // we don't need the y coordinate anyway
            }
        }
    }
    return true;
}