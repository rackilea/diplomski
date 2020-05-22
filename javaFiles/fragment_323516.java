@Override
public void surfaceCreated(SurfaceHolder holder){
    thread = new MainThread(getHolder(), this);
    thread.setRunning(true);
    thread.start();
}