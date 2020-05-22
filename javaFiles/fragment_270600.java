boolean isLauncherInstalled  () {
    final String myLauncherPackageName = "LAUNCHER PACKAGE NAME"; // com.sec.android.app.launcher

    final IntentFilter filterCategory = new IntentFilter(Intent.ACTION_MAIN);
    filter.addCategory(Intent.CATEGORY_HOME);

    List<IntentFilter> filters = new ArrayList<IntentFilter>();
    filters.add(filterCategory);

    List<ComponentName> activities = new ArrayList<ComponentName>();
    final PackageManager packageManager = (PackageManager) getPackageManager();

    packageManager.getPreferredActivities(filters, activities, null);

    for (ComponentName activity : activities) {
        if (myLauncherPackageName.equals(activity.getPackageName())) {
            return true; // Is a match so you have a Launcher installed. 
        }
    }
    return false; // No Launcher. 
}