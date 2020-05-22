// Here, thisActivity is the current activity
if (ContextCompat.checkSelfPermission(thisActivity,
            Manifest.permission.ACCESS_FINE_LOCATION)
    != PackageManager.PERMISSION_GRANTED) {

// Should we show an explanation?
if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
        Manifest.permission.ACCESS_FINE_LOCATION)) {

    // Show an expanation to the user *asynchronously* -- don't block
    // this thread waiting for the user's response! After the user
    // sees the explanation, try again to request the permission.

} else {

    // No explanation needed, we can request the permission.

    ActivityCompat.requestPermissions(thisActivity,
            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
            MY_PERMISSIONS_REQUEST_LOCATION);

    // MY_PERMISSIONS_REQUEST_LOCATION is an
    // app-defined int constant. The callback method gets the
    // result of the request.
} else{
 // Run your async task here(you have got location permission already)
 new GetLocationTask(Activity).execute();
}