private static Bitmap rotate(Bitmap bm, int rotation) {
    if (rotation != 0) {
        Matrix matrix = new Matrix();
        matrix.postRotate(rotation);
        Bitmap bmOut = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
        return bmOut;
    }
    return bm;
}