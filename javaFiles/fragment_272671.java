public class MainView extends SurfaceView implements SurfaceHolder.Callback {
        public MainView(Context context, AttributeSet attrs) {
            super(context, attrs);
            SurfaceHolder holder = getHolder(); 
            holder.addCallback(this);        // Register this view as a surface change listener
            setFocusable(true);              // make sure we get key events
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);

            // Check if the touch pointer is the one you want
            if (event.getPointerId(event.getActionIndex()) == 0) {
                switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // User touched screen...
                case MotionEvent.ACTION_CANCEL:
                    // User dragged his finger out of the view bounds...
                case MotionEvent.ACTION_UP:
                    // User raised his finger...
                case MotionEvent.ACTION_MOVE:
                    // User dragged his finger...

                // Update the blending effect bitmap here and trigger a frame redraw,
                // if you don't already have an animation thread to do it for you.

                return true;
            }

            return false;
        }

        /*
         * Callback invoked when the Surface has been created and is ready to be
         * used.
         */
        public void surfaceCreated(SurfaceHolder holder) {
            // You need to wait for this call back before attempting to draw
        }

        /*
         * Callback invoked when the Surface has been destroyed and must no longer
         * be touched. WARNING: after this method returns, the Surface/Canvas must
         * never be touched again!
         */
        public void surfaceDestroyed(SurfaceHolder holder) {
            // You shouldn't draw to this surface after this method has been called
        }
    }