public void camera(View view) {
    toCamera();
}

private void toCamera() {
    if (!isCheckPermission()){
        return;
    }

    if (isProcessWasFinish()) {
        startActivity(new Intent(getApplicationContext(), CameraActivity.class));
        overridePendingTransition(R.anim.open_next, R.anim.close_main);
    } else {
        startActivity(new Intent(getApplicationContext(), UserDataScreen.class));
        overridePendingTransition(R.anim.open_next, R.anim.close_main);
    }
}

private boolean isCheckPermission() {
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
            PackageManager.PERMISSION_GRANTED) {

        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            showMessageOKCancel("You need to allow access to Camera");
            return false;
        }

        // No explanation needed, we can request the permission.

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA},
                MY_PERMISSIONS_REQUEST);
        return false;
        // MY_PERMISSIONS_REQUEST is an
        // app-defined int constant. The callback method gets the
        // result of the request.
    }

    return true;
}

private void showMessageOKCancel(String message) {
    new AlertDialog.Builder(MainActivity.this)
            .setMessage(message)
            .setPositiveButton("OK", listener)
            .setNegativeButton("Cancel", listener)
            .create()
            .show();
}

DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

    final int BUTTON_NEGATIVE = -2;
    final int BUTTON_POSITIVE = -1;

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case BUTTON_NEGATIVE:
                // int which = -2
                dialog.dismiss();
                break;

            case BUTTON_POSITIVE:
                // int which = -1
                ActivityCompat.requestPermissions(
                        MainActivity.this, new String[]{android.Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST);
                dialog.dismiss();
                break;
        }
    }
};

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                       @NonNull int[] grantResults) {
    switch (requestCode) {
        case MY_PERMISSIONS_REQUEST: {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e(MY_LOG, "Camera permission Granted");
                // permission was granted, yay! Do the
                // contacts-related task you need to do.

                toCamera();

            } else {
                Log.e(MY_LOG, "Camera permission Denied");
                // permission denied, boo! Disable the
                // functionality that depends on this permission.
            }
        }
        default: {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

        // other 'case' lines to check for other
        // permissions this app might request
    }
}