final PackageManager pm = context.getPackageManager();
        // get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            // get the UID for the selected app
            UID = packageInfo.uid;
            String package_name = packageInfo.packageName;
          Log.d("mypackagename",package_name+"");
            ApplicationInfo app = null;
            try {
                app = pm.getApplicationInfo(package_name, 0);
            } catch (PackageManager.NameNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String name = (String) pm.getApplicationLabel(app);
            Drawable icon = pm.getApplicationIcon(app);
            // internet usage for particular app(sent and received)
            double received = (double) TrafficStats.getUidRxBytes(UID)
                    / (1024 * 1024);
            double send = (double) TrafficStats.getUidTxBytes(UID)
                    / (1024 * 1024);
            double totalab = received + send;}