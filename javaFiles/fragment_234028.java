PackageManager packageManager = getPackageManager();
        List<PackageInfo> packageList = packageManager.getInstalledPackages(0);
        for (PackageInfo pi : packageList) {
            ApplicationInfo ai = pi.applicationInfo;
            if ((ai.flags & ApplicationInfo.FLAG_SYSTEM) == 1){
                Log.d("APP_NAME", ai.loadLabel(packageManager).toString());
                Log.d("PACKAGE_NAME", pi.packageName);
                Log.d("APP_VERSION", pi.versionName);
            }
        }