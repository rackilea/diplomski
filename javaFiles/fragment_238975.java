public class MainThread extends Thread {
    // (abridged) Game logic loop
    @Override
    public void run() {
        Canvas canvas;
        Log.d(TAG, "Starting game loop");
        while (running) {
            canvas = null;
            // try locking the canvas for exclusive pixel editing
            // in the surface
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    // update game state
                    mainView.update();
                    // render state to the screen
                    if (canvas != null) mainView.render(canvas); // canvas == null when activity is in background.
                    // ... my code then handles sleeping, etc. for fixed fps.
                }
            } finally {
            // in case of an exception the surface is not left in
            // an inconsistent state
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}