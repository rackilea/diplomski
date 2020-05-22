private boolean singleTapped = false;
private long lastTapTime = 0;
private long doubleTapInterval = 1000;

@Override
public void onTouchEvent(MotionEvent event) {
    if (!singleTapped) {
        singleTapped = true;
        lastTapTime = System.currentTimeMillis();
        super.onTouchEvent (event);
        return;
    }

    long tapInterval = System.currentTimeMillis() - lastTapTime;
    if (tapInterval <= doubleTapInterval) {
        float x = event.getX();
        float y = event.getY();
        SurfaceHolder holder = getSurfaceHolder();
        Canvas canvas = null;

        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
            // Enter it all here
            canvas.restore();


            }
        } finally {
            if (canvas != null)
            holder.unlockCanvasAndPost(canvas);
        }
    }

    super.onTouchEvent(event);
}