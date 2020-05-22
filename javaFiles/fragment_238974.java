@Override
public void surfaceCreated(SurfaceHolder surfaceHolder) {
    Log.d(TAG, "Surface created");
    tf = Typeface.create("Roboto", Typeface.BOLD);
    recalc=true;
    if(!thread.isAlive()) {
        thread.setRunning(true);
        thread.start();
    }
}