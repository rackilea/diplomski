PackageManager localPackageManager = getPackageManager();

    // Main thing is it will return the launcher, If the app dont have launcher, use getPackageInfo(package, 0) will NameNotFoundException if no package
    Intent launchIntent = localPackageManager.getLaunchIntentForPackage("[Seconf app package name]");

    if (launchIntent != null) {
        // the app number (2) is install
    } else {
        // not installed.
    }