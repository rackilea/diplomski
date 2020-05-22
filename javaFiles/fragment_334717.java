SurfaceHolder holder = surfaceView.getHolder();
Canvas c = null;
try {
    c = holder.lockCanvas(null);
    synchronized(holder) {
        // draw here
        // c.drawBitmap() or whatever
    }
} finally {
    if(c != null) 
        holder.unlockCanvasAndPost(c);
}