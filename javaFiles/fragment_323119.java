@Override
public void run() {
    Canvas c;
    while (mRunning) {
        c = null;
        try {
            c = mSurfaceHolder.lockCanvas();
            if (c != null) {
                mSurface.doDraw(c);
            }
        }
        finally {
            if (c != null) {
                try {
                    mSurfaceHolder.unlockCanvasAndPost(c);
                }
                catch (Exception e) { }
            }
        }
    }
}