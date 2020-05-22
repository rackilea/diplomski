private String getSoftwareVersion() {
    try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName;//EDIT: versionCode would be better
    } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Package name not found", e);
    };
 }