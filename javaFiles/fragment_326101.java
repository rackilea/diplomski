private static native Bitmap nativeDecodeRegion(int lbm,
    int start_x, int start_y, int width, int height,
    BitmapFactory.Options options);
private static native int nativeGetWidth(int lbm);
private static native int nativeGetHeight(int lbm);
private static native void nativeClean(int lbm);
// ...multiply nativeNewInstance overloads follow