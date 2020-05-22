//check this code with some hard work then you will rock
 List<PackageInfo> apps = getPackageManager().getInstalledPackages(0);

    ArrayList<AppInfo> res = new ArrayList<AppInfo>();
    for(int i=0;i<apps.size();i++) {
                    PackageInfo p = apps.get(i);

                    AppInfo newInfo = new AppInfo();
                    newInfo.appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
                    newInfo.pname = p.packageName;
                    newInfo.versionName = p.versionName;
                    newInfo.versionCode = p.versionCode;
                    newInfo.icon = p.applicationInfo.loadIcon(getPackageManager());
                    res.add(newInfo);
                    }
                }

    class AppInfo {
        String appname = "";
        String pname = "";
        String versionName = "";
        int versionCode = 0;
        Drawable icon;

    }