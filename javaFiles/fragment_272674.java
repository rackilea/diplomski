public class MainView extends SurfaceView implements Callback {

    private SurfaceHolder holder;
    private Bitmap operation;
    private Bitmap bmp2;
    private boolean surfaceReady;

    // took out AttributeSet attrs
    public MainView(Context context, Bitmap operation, Bitmap bmp2) {
        super(context);

        this.operation = operation;
        this.bmp2 = bmp2;

        holder = getHolder();     // Fix: proper reference the instance variable
        holder.addCallback(this); // Register this view as a surface change
                                    // listener
        setFocusable(true); // make sure we get key events
    }

    // Added so the blending operation is made in one place so it can be more easily upgraded
    private void blend(int x, int y) {
        if (x >= 0 && y >= 0 && x < bmp2.getWidth() && x < operation.getWidth() && y < bmp2.getHeight() && y < operation.getHeight())
            operation.setPixel(x, y, bmp2.getPixel(x, y));
    }

    // Added so the drawing is now made in one place
    private void drawOverlays() {
        Canvas c = null;
        try {
            c = holder.lockCanvas(null);
            synchronized (holder) {
                if (c != null)
                    c.drawBitmap(operation, 0, 0, null); // Render blending
                                                            // effect
            }
        } catch (Exception e) {
            Log.e("SurfaceView", "Error drawing frame", e);
        } finally {
            // do this in a finally so that if an exception is thrown
            // during the above, we don't leave the Surface in an
            // inconsistent state
            if (c != null) {
                holder.unlockCanvasAndPost(c);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        if (!surfaceReady)     // No attempt to blend or draw while surface isn't ready
            return false;

        // Check if the touch pointer is the one you want
        if (event.getPointerId(event.getActionIndex()) == 0) {
            switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // User touched screen. Falls through ACTION_MOVE once there is no break

            case MotionEvent.ACTION_MOVE:
                // User dragged his finger...
                blend((int) event.getX(), (int) event.getY());

            }
            // Update the blending effect bitmap here and trigger a frame
            // redraw,
            // if you don't already have an animation thread to do it for you.
            drawOverlays();
            return true;
        }

        return false;
    }

    /*
     * Callback invoked when the Surface has been created and is ready to be
     * used.
     */
    public void surfaceCreated(SurfaceHolder holder) {
        surfaceReady = true;
        drawOverlays();
    }

    /*
     * Callback invoked when the Surface has been destroyed and must no longer
     * be touched. WARNING: after this method returns, the Surface/Canvas must
     * never be touched again!
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        // You shouldn't draw to this surface after this method has been called
        surfaceReady = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
        // TODO Auto-generated method stub
    }

}