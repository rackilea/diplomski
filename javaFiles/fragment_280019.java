public boolean onTouch(View arg0, MotionEvent arg1) {
        if (!mLoaded)
            return false;

        Canvas c = mSurfaceHolder.lockCanvas();
        drawTap(c, arg1);
        mSurfaceHolder.unlockCanvasAndPost(c);

        return true;
    }