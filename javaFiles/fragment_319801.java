public static  Bitmap cropAndScale (Bitmap source,int scale){
    int factor = source.getHeight() <= source.getWidth() ? source.getHeight(): source.getWidth();
    int longer = source.getHeight() >= source.getWidth() ? source.getHeight(): source.getWidth();
    int x = source.getHeight() >= source.getWidth() ?0:(longer-factor)/2;
    int y = source.getHeight() <= source.getWidth() ?0:(longer-factor)/2;
    source = Bitmap.createBitmap(source, x, y, factor, factor);
    source = Bitmap.createScaledBitmap(source, scale, scale, false);
    return source;
}