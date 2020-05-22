if (ContextCompat.checkSelfPermission(thisActivity,
    Manifest.permission.ACCESS_COARSE_LOCATION)
!= PackageManager.PERMISSION_GRANTED) {

// Permission is not granted
// Should we show an explanation?
if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
        Manifest.permission.ACCESS_COARSE_LOCATION)) {

    // Show an explanation to the user *asynchronously* -- don't block
    // this thread waiting for the user's response! After the user
    // sees the explanation, try again to request the permission.

} else {

    // No explanation needed; request the permission
    ActivityCompat.requestPermissions(thisActivity,
            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
            MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);

    // MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION is an
    // app-defined int constant. The callback method gets the
    // result of the request.
}
} else {
// Permission has already been granted
}