private void killOtherApps(String packageTokill){

    List<ApplicationInfo> packages;
    PackageManager pm;
    pm = getPackageManager();
    //get a list of installed apps.
    packages = pm.getInstalledApplications(0);


    ActivityManager mActivityManager = (ActivityManager) MainActivity.this.getSystemService(Context.ACTIVITY_SERVICE);
    String myPackage = getApplicationContext().getPackageName();

    for (ApplicationInfo packageInfo : packages) {

        if((packageInfo.flags & ApplicationInfo.FLAG_SYSTEM)==1) {
            continue;
        }
        if(packageInfo.packageName.equals(myPackage)) {
            continue;
        }
        if(packageInfo.packageName.equals(packageTokill)) {
            mActivityManager.killBackgroundProcesses(packageInfo.packageName);    
        }

    }

}