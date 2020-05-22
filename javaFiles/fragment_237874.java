public static int convertDpsToPixels(Context context, int dps) {
    // http://developer.android.com/guide/practices/screens_support.html

    // Convert the dps to pixels
    final float scale = context.getResources().getDisplayMetrics().density;
    final float dpsFloat = dps;
    return (int) (dpsFloat * scale + 0.5f);

}