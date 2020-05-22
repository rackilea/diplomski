private void draw() {

    imageview.draw(canvas);
    canvas.drawColor(Color.Black);
    canvas.drawRect(50, 50, 350, 350,mPaint);
    imageview.setImageBitmap(mybitmap);

}