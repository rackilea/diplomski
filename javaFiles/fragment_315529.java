List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

    try {
        PackageInfo packageInfo = pm.getPackageInfo("ashish.app.com.getpremissions", PackageManager.GET_PERMISSIONS);

        //Get Permissions
        String[] requestedPermissions = packageInfo.requestedPermissions;

        if (requestedPermissions != null) {
            for (int i = 0; i < requestedPermissions.length; i++) {

                Log.d("test", requestedPermissions[i]);

                String[] last = requestedPermissions[i].toString().split("\\.");

                String lastOne = last[last.length - 1];

                if (!lastOne.contains("_")) {
                    Log.e("app", "permissions is----" + lastOne.toLowerCase());
                } else {
                    String[] permissions = lastOne.split("_");
                    StringBuffer sb = new StringBuffer();
                    for (int index = 0; index < permissions.length; index++) {
                        sb.append(permissions[index].toLowerCase());
                        sb.append(" ");
                    }
                    Log.e("app", "permissions is----" + sb.toString());
                }

                // itemname.add();

            }
        }
    } catch (PackageManager.NameNotFoundException e) {
        e.printStackTrace();
    }