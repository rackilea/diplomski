class Applications {
    private String packageName;
    private String labelName;
 }

 private void getAllApps() {
    final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
    mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
    List<ResolveInfo> activities = getPackageManager()
            .queryIntentActivities(mainIntent, 0);
    for (ResolveInfo resolveInfo : activities) {
        Applications applications = new Applications();
        applications.labelName = resolveInfo.loadLabel(getPackageManager())
                .toString().toLowerCase();
        applications.packageName = resolveInfo.activityInfo.packageName
                .toString();
        applicationsArrayList.add(applications);
    }
}

private void openApplication(String appName) {

    String packageName = null;

    // matching the package name with label name
    for (int i = 0; i < applicationsArrayList.size(); i++) {
        if (applicationsArrayList.get(i).labelName.trim().equals(
                appName.trim())) {
            packageName = applicationsArrayList.get(i).packageName;
            break;
        }
    }

    // to launch the application
    Intent i;
    PackageManager manager = getPackageManager();
    try {
        i = manager.getLaunchIntentForPackage(packageName);
        if (i == null)
            throw new PackageManager.NameNotFoundException();
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(i);
    } catch (PackageManager.NameNotFoundException e) {

    }
}