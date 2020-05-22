private Canvas myCanvas = null;
private Bitmap myCanvasBitmap = null;
private Matrix identityMatrix;

public mySurfaceCreated(canvasWidth, canvasHeight){
    myCanvasBitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
    myCanvas = new Canvas();
    myCanvas.setBitmap(myCanvasBitmap);
    identityMatrix = new Matrix();
}

public void myDraw(Canvas canvas) {
    // Draw stuff onto myCanvas, NOT the canvas given by the android OS.
    drawStuff(myCanvas);
    // Draw onto the canvas given by the android OS.
    canvas.drawBitmap(myCanvasBitmap, identityMatrix, null);

}