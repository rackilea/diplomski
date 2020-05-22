public static void saveAllDrawablesToSdcard(final Context context, final File directory) throws Exception {
    new Thread() {

        @Override
        public void run() {
            try {
                directory.mkdirs();
                final Field[] fields = R.drawable.class.getFields();
                final Resources res = context.getResources();
                for (Field field : fields) {
                    final int id = (Integer) field.get(null);
                    final Drawable drawable = res.getDrawable(id);
                    final Bitmap bitmap = drawableToBitmap(drawable);
                    final File file = new File(directory, field.getName() + ".png");
                    saveBitmapAsPng(bitmap, file.getAbsolutePath());
                }
            } catch (Exception e) {
            }
        }
    }.start();
}

/**
 * Converts a {@link Drawable} to a {@link Bitmap}
 *
 * @param drawable
 *            The {@link Drawable} to convert
 * @return The converted {@link Bitmap} or {@code null} if it was unable to be converted.
 */
public static Bitmap drawableToBitmap(final Drawable drawable) {
    if (drawable instanceof BitmapDrawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }
    final int height = drawable.getIntrinsicHeight();
    final int width = drawable.getIntrinsicWidth();
    if (width <= 0 || height <= 0) {
        return null;
    }
    final Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
    final Canvas canvas = new Canvas(bitmap);
    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
    drawable.draw(canvas);
    return bitmap;
}

/**
 * Saves a {@link Bitmap} as a PNG file.
 *
 * @param bmp
 *            a {@link Bitmap}
 * @param path
 *            the path to save the bitmap to
 * @return {@code true} if successfully created.
 */
public static final boolean saveBitmapAsPng(final Bitmap bitmap, final String path) {
    try {
        final File file = new File(path);
        final File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        final FileOutputStream fos = new FileOutputStream(file, false);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100 /* ignored for PNG */, fos);
        fos.flush();
        fos.close();
    } catch (final Exception e) {
        return false;
    }
    return true;
}