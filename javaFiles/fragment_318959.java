// decodes image and scales it to reduce memory consumption
private Bitmap decodeImage(String picturePath) {
    try {
        File file = new File(picturePath);
        // Get image size
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(new FileInputStream(file), null, opts);

        // The new size we want to scale to
        final int MIN_SIZE = 70;

        // Find the correct scale value.
        int scale = 1;
        while (((opts.outWidth / scale) >> 1) >= MIN_SIZE
                && ((opts.outHeight / scale) >> 1) >= MIN_SIZE) {
            scale <<= 1;
        }

        BitmapFactory.Options opts2 = new BitmapFactory.Options();
        opts2.inSampleSize = scale;
        return BitmapFactory.decodeStream(new FileInputStream(file), null, opts2);
    } catch (FileNotFoundException e) {
    }
    return null;
}