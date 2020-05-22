@Override
public void onRequestPermissionsResult(int requestCode,
    String permissions[], int[] grantResults) {
switch (requestCode) {
    case MY_PERMISSIONS_REQUEST_LOCATION: {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            // permission was granted, Execute the asynctask here
            new GetLocationTask(Activity).execute();
        } else {

            // permission denied, boo! Disable the
            // functionality that depends on this permission.
        }
        return;
    }

    // other 'case' lines to check for other
    // permissions this app might request
}
}