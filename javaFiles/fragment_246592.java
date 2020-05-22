private void requestPermissions() {
    requestPermissions(new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    });
}

private void requestPermissions(String[] permissions) {
    List<String> notGranted = new ArrayList<>();

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        for(String permission : permissions) {
            if(checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                notGranted.add(permission);
            }
        }

        if(!notGranted.isEmpty()) {
            ActivityCompat.requestPermissions(this, notGranted.toArray(new String[0]),
                    FrontendConstants.PERMISSION_REQUEST_CODE);
        }
    }
}

@Override
public void onRequestPermissionsResult(int requestCode,
                                       String permissions[], int[] grantResults) {
    if(FrontendConstants.PERMISSION_REQUEST_CODE == requestCode) {
        PermissionsHelper helper = new PermissionsHelper(permissions, grantResults);

        if(helper.isPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Log.i(TAG, "+++ User accepted filesystem permission request");
        }
        else {
            Log.e(TAG, "--- User rejected filesystem permission request");
        }

        if(helper.arePermissionsGranted(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)) {
            Log.i(TAG, "+++ User accepted GPS permission request");
        }
        else {
            Log.e(TAG, "--- User rejected GPS permission request");
        }
    }
}