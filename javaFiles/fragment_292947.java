public class AnimatedViewClass extends View {

GestureDetector gestureDetector;

public AnimatedViewClass(Context context) {
    super(context);
    gestureDetector = new GestureDetector(getContext(), new GestureDetectorListener());
}

@Override
public boolean onTouchEvent(MotionEvent event) {
    gestureDetector.onTouchEvent(event);
    return super.onTouchEvent(event);
}

private void onSwipeRight(){
    // swipe right detected
    // do stuff
    invalidate();
}


private void onSwipeLeft(){
    // swipe left detected
    // do stuff
    invalidate();
}

private class GestureDetectorListener extends
        GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        // onSwipeRight()
        // onSwipeLeft()

        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return super.onDown(e);
    }
}


private Runnable r = new Runnable() {
    @Override
    public void run() {
        if(continueAnimation) {
            invalidate();
        }
    }
};


protected void onDraw(Canvas c) {

    if (x < 0) {
        x = this.getWidth() / 2 - 100;
        y = this.getHeight() / 2 - 100;
    } else {
        x += xVelocity;

        if ((x > this.getWidth() - ball.getBitmap().getWidth()) || (x < 0)) {
            boolean continueAnimation = false;
        }
    }

    c.drawBitmap(ball.getBitmap(), x, y, null);

    if (continueAnimation) {
        h.postDelayed(r, FRAME_RATE);
    } else {
        x = this.getWidth() - ball.getBitmap().getWidth();
    }

}


}