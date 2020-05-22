final String packName = "com.example2.app";
    String mDrawableName = "app_icon";

    try {
        PackageManager manager = getPackageManager();
        Resources mApk1Resources = manager.getResourcesForApplication(packName);

        int mDrawableResID = mApk1Resources.getIdentifier(mDrawableName, "drawable",packName);

        Drawable myDrawable = mApk1Resources.getDrawable( mDrawableResID );

        if( myDrawable != null )
            TEST.setBackgroundDrawable(myDrawable );

    }
    catch (NameNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }