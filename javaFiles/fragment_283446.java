public static void installedApps(Context context) {
    PackageManager pm = context.getPackageManager();
    List<ApplicationInfo> packagelist = pm.getInstalledApplications(PackageManager.GET_META_DATA);
    JSONObject resp = new JSONObject();

    for (ApplicationInfo applicationInfo : packagelist) {

        CharSequence app = applicationInfo.loadLabel(context.getPackageManager());
        String pckge = applicationInfo.packageName;
        JSONObject json = new JSONObject();

        try {
            //Get Permissions
            PackageInfo packageInfo = pm.getPackageInfo(applicationInfo.packageName, PackageManager.GET_PERMISSIONS);
            String[] requestedPermissions = packageInfo.requestedPermissions;
            if (requestedPermissions != null) {
                json.put("app", app);
                json.put("package", pckge);
                JSONArray jsonArray = new JSONArray();
                for (String requestedPermission : requestedPermissions) {
                    jsonArray.put(requestedPermission);
                }
                json.put("permission", jsonArray);
                resp.put(applicationInfo.name, json); // something to identify each app
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // return resp.toString() or store in file or whatever you want to do
}