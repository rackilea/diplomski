class myThread extends Thread {
    Context context;
    //Everything that you currently have in your UI thread should be in here...

    /* Constructor for thread. Pass useful things like context, drawing surface, etc */
    public myThread(Context context) {
        this.context = context;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    @Override
    public void run() {

    Canvas canvas;

    Log.d(TAG, "Starting game loop");

    long beginTime; // The time when the cycle begun
    long timeDiff; // The time it took for the cycle to execute
    int sleepTime; // ms to sleep (<0 if we're behind)
    int framesSkipped; // Number of frames being skipped

    sleepTime = 0;

    while (running) {
        canvas = null;

        // Try locking the canvas
        try {
            canvas = this.surfaceHolder.lockCanvas();
            if (canvas != null) {
                synchronized (surfaceHolder) {
                    beginTime = System.currentTimeMillis();
                    framesSkipped = 0; // resetting the frames skipped
                    // Update game state here!
                    this.gameView.update();
                    // Render state to the screen
                    // Draws the canvas on the panel
                    this.gameView.render(canvas);
                    // Calculate how long time the cycle took
                    timeDiff = System.currentTimeMillis() - beginTime;
                    // Calculate sleep time
                    sleepTime = (int) (FRAME_PERIOD - timeDiff);

                    if (sleepTime > 0) {
                        try {
                            // Send the thread to sleep for a short period,
                            // very useful for battery saving
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {

                        }
                    }

                    while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
                        // Need to catch up by updating without rendering
                        // Update game state here!
                        this.gameView.update();

                        // Add frame period to check if in next frame
                        sleepTime += FRAME_PERIOD;
                        framesSkipped++;
                    }
                }
            }
            } finally {
                // In case of an exception the surface is not left in
                // an inconsistent state
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            } // End finally
        }
    }         
}