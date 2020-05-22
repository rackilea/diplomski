public Bitmap flip(Bitmap d)
{
    Matrix m = new Matrix();
    m.preScale(-1, 1);
    Bitmap dst = Bitmap.createBitmap(d, 0, 0, d.getWidth(), d.getHeight(), m, false);
    dst.setDensity(DisplayMetrics.DENSITY_DEFAULT);
    return dst;
}

public Bitmap rotateBitmap(Bitmap source, float angle)
{
    //Rotates Bitmap
    Matrix matrix = new Matrix();
    matrix.postRotate(angle);
    return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
}