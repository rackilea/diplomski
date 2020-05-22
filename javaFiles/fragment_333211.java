public static Bitmap darkenText(Bitmap bmp,  float contrast)
{
    ColorMatrix cm = new ColorMatrix();
     float scale = contrast + 1.f;
     float translate = (-.5f * scale + .5f) * 255.f;
  cm.set(new float[] {
         scale, 0, 0, 0, translate,
         0, scale, 0, 0, translate,
         0, 0, scale, 0, translate,
         0, 0, 0, 1, 0 });

    Bitmap ret = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());

    Canvas canvas = new Canvas(ret);

    Paint paint = new Paint();
    paint.setColorFilter(new ColorMatrixColorFilter(cm));
    canvas.drawBitmap(bmp, 0, 0, paint);

    return ret;
}