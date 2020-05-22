public static Bitmap getResizedBitmap(Bitmap source, int toWidth, int toHeight) {
        int width = source.getWidth();
        int height = source.getHeight();
        float scaleWidth = ((float) toWidth) / width;
        float scaleHeight = ((float) toHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(source, 0, 0, toWidth, toHeight, matrix, false);
    }