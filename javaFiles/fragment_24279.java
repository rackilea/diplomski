public void show(boolean showWithVersionCheck) {
        try {
            // Get the versionCode of the Package, which must be different (incremented) in each release on the market in the AndroidManifest.xml
            final PackageInfo packageInfo = mActivity.getPackageManager().getPackageInfo(mActivity.getPackageName(), PackageManager.GET_ACTIVITIES);

            final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mActivity);

            final long lastVersionCode = prefs.getLong(LAST_VERSION_CODE_KEY, 0);

            boolean showDialog = true;
            if(showWithVersionCheck) {
                if(packageInfo.versionCode == lastVersionCode) {
                   showDialog = false; 
                }
            }

            if (showDialog) {
                Log.i(LOG_TAG, "versionCode " + packageInfo.versionCode + "is different from the last known version " + lastVersionCode);

                final String title = mActivity.getString(R.string.app_name) + " v" + packageInfo.versionName;

                final String message = mActivity.getString(R.string.whatsnew);

                // Show the News since last version
                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity)
                        .setTitle(title)
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok, new Dialog.OnClickListener() {

                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Mark this version as read
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putLong(LAST_VERSION_CODE_KEY, packageInfo.versionCode);
                                editor.commit();
                                dialogInterface.dismiss();
                            }
                        });
                builder.create().show();
            } else {
                Log.i(LOG_TAG, "versionCode " + packageInfo.versionCode + "is already known");
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}