final PackageManager pm = getPackageManager();
    final String pn = getPackageName();
    PackageInfo pi = null;
    try {
        pi = pm.getPackageInfo(pn, 0);
    } catch (NameNotFoundException e) {
        //LOG the exception
    }
    curVersionCode = pi!=null ? pi.versionCode:-1;