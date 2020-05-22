private Bitmap getScaledBitmap(String picturePath, int width, int height) {
    BitmapFactory.Options sizeOptions = new BitmapFactory.Options();
    sizeOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(picturePath, sizeOptions);

    int inSampleSize = calculateInSampleSize(sizeOptions, width, height);

    sizeOptions.inJustDecodeBounds = false;
    sizeOptions.inSampleSize = inSampleSize;

    return BitmapFactory.decodeFile(picturePath, sizeOptions);
}


private int calculateInSampleSize(BitmapFactory.Options options,
                                      int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        // Calculate ratios of height and width to requested height and width
        final int heightRatio = Math.round((float) height / (float) reqHeight);
        final int widthRatio = Math.round((float) width / (float) reqWidth);

        // Choose the smallest ratio as inSampleSize value, this will
        // guarantee a final image with both dimensions larger than or equal to the
        // requested height and width.
        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
     }
    return inSampleSize;
}