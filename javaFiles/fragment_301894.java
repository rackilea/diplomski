private Bitmap darkenBitMap(Bitmap bm) {

    Canvas canvas = new Canvas(bm);
    Paint p = new Paint(Color.RED);
    //ColorFilter filter = new LightingColorFilter(0xFFFFFFFF , 0x00222222); // lighten
    ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
    p.setColorFilter(filter);
    canvas.drawBitmap(bm, new Matrix(), p);

    return bm;
}