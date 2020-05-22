boolean mSurfaceExists;
...
public void surfaceDestroyed(SurfaceHolder holder) {
    mSurfaceExists = false;
    ...
}

public void surfaceCreated(SurfaceHolder holder) {
    mSurfaceExists = true;
    ...
}

protected void onWindowVisibilityChanged(int visibility) {
    // only call base if there's a surface
    if(mSurfaceExists)
        super.onWindowVisibilityChanged(visibility);
}