private Bitmap decodeBitmap(String filePath, int reqWidth, int reqHeight, int scale) throws IOException, Exception {
    if (scale > 3)
        throw new Exception("scale size cannot be greater than 3");
    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
    bmOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(filePath, bmOptions);
    int photoW = bmOptions.outWidth;
    int photoH = bmOptions.outHeight;

    // Determine how much to scale down the image
    bmOptions.inSampleSize = scale + Math.min(photoW / reqWidth, photoH / reqHeight);
    bmOptions.inJustDecodeBounds = false;
    try {
        Bitmap bm = BitmapFactory.decodeFile(filePath, bmOptions);
        ExifInterface exif = new ExifInterface(filePath);
        String orientString = exif.getAttribute(ExifInterface.TAG_ORIENTATION);
        int orientation = orientString != null ? Integer.parseInt(orientString) : ExifInterface.ORIENTATION_NORMAL;

        int rotationAngle = 0;
        if (orientation == ExifInterface.ORIENTATION_ROTATE_90) rotationAngle = 90;
        if (orientation == ExifInterface.ORIENTATION_ROTATE_180) rotationAngle = 180;
        if (orientation == ExifInterface.ORIENTATION_ROTATE_270) rotationAngle = 270;

        Matrix matrix = new Matrix();
        matrix.setRotate(rotationAngle, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);
        return Bitmap.createBitmap(bm, 0, 0, photoW, photoH, matrix, true);
    } catch (OutOfMemoryError exception) {
        exception.printStackTrace();
        return decodeBitmap(filePath, reqWidth, reqHeight, scale + 1);
    }
}