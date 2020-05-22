Bitmap image;
Matrix m;
.
.
.
public YourClass(){
    m = new Matrix();
    image = Bitmap.createBitmap(image, 0, 0, width, height,);
}
.
.
.
public void mainGameLoop(Canvas c){
    m.setRotate(angle, imageCenterX, imageCenterY);
    yourCanvas.drawBitmap(image, m, null);
}