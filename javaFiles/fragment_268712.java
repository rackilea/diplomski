Canvas canvas = null;
try {
    canvas = ourHolder.lockCanvas();
    synchronized (ourHolder) {
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(enemy1, enemy1X, enemy1Y, null);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawText("XXXX", 200, 100, paint);
    }
} catch (Exception e) {
    Log.e(TAG, "run() lockCanvas()", e);
} finally {
    if (canvas != null) {
        ourHolder.unlockCanvasAndPost(canvas);
    }
}