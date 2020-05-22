public boolean isActivityVisible(Context context) {
    ActivityManager am = (ActivityManager) context.
    getSystemService(Activity.ACTIVITY_SERVICE);
    String className = am.getRunningTasks(1).get(0).topActivity.getClassName();
    return Main.class.getName().equals(className);
}