//For resource
image.setImageBitmap(decodeSampledBitmapFromResource("android.resource://com.my.package/drawable/image_name"));
 //For file
image.setImageBitmap(decodeSampledBitmapFromResource(filepath));


public static int calculateInSampleSize(BitmapFactory.Options options,
        int reqWidth, int reqHeight) {

    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 2;
    if (height >= reqHeight || width >= reqWidth) {
        inSampleSize *= 2;
    }
    return inSampleSize;
}

public static Bitmap decodeSampledBitmapFromResource(String file,
        int reqWidth, int reqHeight) {

    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(file, options);
    options.inSampleSize = calculateInSampleSize(options, reqWidth,
            reqHeight);
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(file, options);
}