String permission = Manifest.permission.ACCESS_FINE_LOCATION;
if (!isPermissionGranted(permission)) {

  if (isRationaleExplanationNeeded(permission)) {
    //show dialog to explain why you need permission
  } else {
    ActivityCompat.requestPermissions(this, new String[]{permission},
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
  }
} else {
  //do what ever you need to do
}