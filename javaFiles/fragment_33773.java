PackageManager pm = context.getPackageManager();
    List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.GET_PERMISSIONS);
    for (PackageInfo pi : packages)
    {
        for (String usesPermission : pi.requestedPermissions){
            if (usesPermission.equalsIgnoreCase("com.google.android.c2dm.permission.RECEIVE")){
                Log.d(TAG, "app with permission to receive push: "+pi.applicationInfo.name);
            }
        }
    }