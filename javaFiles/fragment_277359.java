/**
     * Converts dip to px.
     *
     * @param context -  Context of calling class.
     * @param dip     - Value in dip to convert.
     * @return - Converted px value.
     */
    public static int convertDipToPixels(Context context, int dip) {
        if (context == null)
            return 0;
        Resources resources = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, resources.getDisplayMetrics());
        return (int) px;
    }