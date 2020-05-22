/**
 * reduces the size of the image
 * @param image
 * @param maxSize
 * @return
 */
public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
    int width = image.getWidth();
    int height = image.getHeight();

    float bitmapRatio = (float)width / (float) height;
    if (bitmapRatio > 0) {
        width = maxSize;
        height = (int) (width / bitmapRatio);
    } else {
        height = maxSize;
        width = (int) (height * bitmapRatio);
    }
    return Bitmap.createScaledBitmap(image, width, height, true);
}