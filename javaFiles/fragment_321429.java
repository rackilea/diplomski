Thread thread;

@Override
public void surfaceCreated(SurfaceHolder holder) {
    thread = new myThread(getContext());

    thread.setRunning(true);
    thread.start();
}