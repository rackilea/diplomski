@Override
public void surfaceCreated(SurfaceHolder surfaceHolder) {
    mRenderThread = new MyThread(getHolder(), this);
    mRenderThread.setRunning(true);
    mRenderThread.start();
}