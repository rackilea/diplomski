public static void clearLightStatusBar(Activity activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        Window window = activity.getWindow();
        window.setStatusBarColor(ContextCompat
             .getColor(activity,R.color.colorPrimaryDark)); 
    }
}