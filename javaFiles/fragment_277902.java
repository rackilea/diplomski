public static Bitmap decodeSampledBitmapFromFile(String photoDir,
                                                 int reqWidth, int reqHeight) {

    // First decode with inJustDecodeBounds=true to check dimensions
    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;

    BitmapFactory.decodeFile(photoDir, options);

    // Calculate inSampleSize
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    options.inPreferredConfig = Bitmap.Config.RGB_565;
    int inSampleSize = 1;

    if (height > reqHeight) {
        inSampleSize = Math.round((float) height / (float) reqHeight);
    }

    int expectedWidth = width / inSampleSize;

    if (expectedWidth > reqWidth) {// If bigger SampSize..
        inSampleSize = Math.round((float) width / (float) reqWidth);
    }


    options.inSampleSize = inSampleSize;

    // Decode bitmap with inSampleSize set
    options.inJustDecodeBounds = false;


    Bitmap photo = BitmapFactory.decodeFile(photoDir, options);

    // WILL CHECK ROTATION FLAGS AND ROTATE AS NECESSARY
    try {
        ExifInterface exif = new ExifInterface(photoDir);
        float rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        float rotationInDegrees = exifToDegrees(rotation);

        Matrix matrix = new Matrix();
        matrix.postRotate(rotationInDegrees);

        // if needs rotating, rotate in memory.
        if(rotationInDegrees != 0)
            photo = Bitmap.createBitmap(photo, 0, 0, photo.getWidth(), photo.getHeight(), matrix, true);

    } catch (OutOfMemoryError e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return photo;
}