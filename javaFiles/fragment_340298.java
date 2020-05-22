private void updateWindow(boolean force, boolean redrawNeeded) {
    ...
    callbacks = getSurfaceCallbacks();
    for (SurfaceHolder.Callback c : callbacks) {
        c.surfaceDestroyed(mSurfaceHolder);
    }