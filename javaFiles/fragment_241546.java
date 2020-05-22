Intent intent = new Intent(Intent.ACTION_MAIN, null);
intent.addCategory(Intent.CATEGORY_LAUNCHER);
List appsList = getPackageManager().queryIntentActivities(intent, 0);

for (Object app : appsList) {
    ResolveInfo resolveInfo = (ResolveInfo) app;
    PackageInfo packageInfo = null;
    try {
        packageInfo = getPackageManager().getPackageInfo(resolveInfo.activityInfo.packageName, PackageManager.GET_PERMISSIONS);
    } catch (NameNotFoundException ex) {
        ex.printStackTrace();
    }

    String[] requestedPermissions = packageInfo.requestedPermissions;
}