foto.setColorFilter(brightIt(100));//foto is my ImageView
//and below is the brightIt func
public static ColorMatrixColorFilter brightIt(int fb) {
    ColorMatrix cmB = new ColorMatrix();
    cmB.set(new float[] { 
        1, 0, 0, 0, fb,
        0, 1, 0, 0, fb,
        0, 0, 1, 0, fb,
        0, 0, 0, 1, 0   });

    ColorMatrix colorMatrix = new ColorMatrix();
    colorMatrix.set(cmB);
    //Canvas c = new Canvas(b2);
    //Paint paint = new Paint();
    ColorMatrixColorFilter f = new ColorMatrixColorFilter(colorMatrix);
    //paint.setColorFilter(f);   
   return f;
}