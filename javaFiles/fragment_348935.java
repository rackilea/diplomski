private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
    try {
        packageManager.getPackageInfo(packageName, 0);
        return true;
    } catch (PackageManager.NameNotFoundException e) {
        return false;
    }
}