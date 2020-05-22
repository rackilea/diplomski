public boolean isLauncherInstalled() {
    final String myLauncherPackageName = "LAUNCHER PACKAGE NAME"; // com.sec.android.app.launcher

    IntentFilter filterCategory = new IntentFilter(Intent.ACTION_MAIN);
    filterCategory.addCategory(Intent.CATEGORY_HOME);

    List<IntentFilter> filters = new ArrayList<IntentFilter>();
    filters.add(filterCategory);

    List<ComponentName> preferredActivities = new ArrayList<ComponentName>();
    final PackageManager packageManager = (PackageManager) getPackageManager();

    packageManager.getPreferredActivities(filters, preferredActivities, myLauncherPackageName);

    if (preferredActivities != null && preferredActivities.size()> 0) {
        return true; // Is a match so you have a Launcher installed.
    }
    return false; // No Launcher. 
}