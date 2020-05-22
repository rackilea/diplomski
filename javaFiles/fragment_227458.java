// Check for permission to access Location
private boolean checkLocationPermission() {
    Log.d(TAG, "checkPermission()");
    // Ask for permission if it wasn't granted yet
    return (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED);
}

// Asks for permissions
private void askPermission() {
    Log.d(TAG, "askPermission()");
    ActivityCompat.requestPermissions(
            this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
    );
}

// Reaction to whether user granted or denied permissions
@Override
public void onRequestPermissionsResult(
        int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    Log.d(TAG, "onRequestPermissionsResult()");
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
        case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                if (checkLocationPermission())
                    mMap.setMyLocationEnabled(true);
            } else {
                // Permission denied
                // TODO
            }
            break;
        }
    }
}