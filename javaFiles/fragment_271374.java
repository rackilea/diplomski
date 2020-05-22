List<PackageInfo> installedPackages = pm.getInstalledPackages(0);
for (PackageInfo installedPackage : installedPackages) {
    String packName = installedPackage.applicationInfo.packageName;

    if ("put AppExtern's packageName here".equals(packName )) {     
        //AppExtern is installed
        final Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setClassName("xclient", "com.xxx.XActivity");

        final Location location = ****; // Get GPS location using LocationManager.
        if(location == null){           // location is null if GPS is disabled for device.
            callbackHandler.post(new Runnable() {
                  @Override
                  public void run() {
                    Toast.makeText(MyActivity.this,
                      "Cannot use GPS. Check your device settings.",Toast.LENGTH_LONG).show();
                    // finish();  you don't need to finish,because AppExtern is not started yet.
                    return;
                    }
                });
        }

        intent.putExtra("latitude", location.getLatitude());
        intent.putExtra("longitude", location.getLongitude());
        startActivity(intent);
        finish();
    }

}

//AppExtern is not installed
//start Google Play app