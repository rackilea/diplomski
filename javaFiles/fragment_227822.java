public static int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
 }


public static void setPaddingForGoogleLogo(GoogleMap map, Context context) {
    map.setPadding(LayoutUtils.dpToPx(15, context),
            LayoutUtils.dpToPx(45, context),
            LayoutUtils.dpToPx(0, context),
            LayoutUtils.dpToPx(85, context));
}