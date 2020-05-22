public class ImageCache {

Set<SoftReference<Bitmap>> mReusableBitmaps;

protected Bitmap getBitmapFromReusableSet(BitmapFactory.Options options) {
    Bitmap bitmap = null;

    if (mReusableBitmaps != null && !mReusableBitmaps.isEmpty()) {
        synchronized (mReusableBitmaps) {
            final Iterator<SoftReference<Bitmap>> iterator
                    = mReusableBitmaps.iterator();
            Bitmap item;

            while (iterator.hasNext()) {
                item = iterator.next().get();

                if (null != item && item.isMutable()) {
                    // Check to see it the item can be used for inBitmap.
                    if (canUseForInBitmap(item, options)) {
                        bitmap = item;

                        // Remove from reusable set so it can't be used again.
                        iterator.remove();
                        break;
                    }
                } else {
                    // Remove from the set if the reference has been cleared.
                    iterator.remove();
                }
            }
        }
    }
    return bitmap;
}

int getBytesPerPixel(Bitmap.Config config) {
    if (config == Bitmap.Config.ARGB_8888) {
        return 4;
    } else if (config == Bitmap.Config.RGB_565) {
        return 2;
    } else if (config == Bitmap.Config.ARGB_4444) {
        return 2;
    } else if (config == Bitmap.Config.ALPHA_8) {
        return 1;
    }
    return 1;
}
public boolean canUseForInBitmap(Bitmap candidate, BitmapFactory.Options targetOptions) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        // From Android 4.4 (KitKat) onward we can re-use if the byte size of
        // the new bitmap is smaller than the reusable bitmap candidate
        // allocation byte count.
        int width = targetOptions.outWidth / targetOptions.inSampleSize;
        int height = targetOptions.outHeight / targetOptions.inSampleSize;
        int byteCount = width * height * getBytesPerPixel(candidate.getConfig());
        return byteCount <= candidate.getAllocationByteCount();
    }

    // On earlier versions, the dimensions must match exactly and the inSampleSize must be 1
    return candidate.getWidth() == targetOptions.outWidth
            && candidate.getHeight() == targetOptions.outHeight
            && targetOptions.inSampleSize == 1;
}

public void addInBitmapOptions(BitmapFactory.Options options) {
    // inBitmap only works with mutable bitmaps, so force the decoder to
    // return mutable bitmaps.
    options.inMutable = true;

    if (this != null) {
        // Try to find a bitmap to use for inBitmap.
        Bitmap inBitmap = getBitmapFromReusableSet(options);

        if (inBitmap != null) {
            // If a suitable bitmap has been found, set it as the value of
            // inBitmap.
            options.inBitmap = inBitmap;
        }
    }
}
public Bitmap decodeSampledBitmapFromFile(Resources res,int id) {

    final BitmapFactory.Options options = new BitmapFactory.Options();

    BitmapFactory.decodeResource(res, id , options);

    // If we're running on Honeycomb or newer, try to use inBitmap.
    addInBitmapOptions(options);

    return BitmapFactory.decodeResource(res, id ,options);
}