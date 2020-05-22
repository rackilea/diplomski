private boolean isPermissionGranted(String permission) {
   int hasRequestedPermission = ContextCompat.checkSelfPermission(this, permission);

   return hasRequestedPermission == PackageManager.PERMISSION_GRANTED;
} 

private boolean isRationaleExplanationNeeded(String permission) {
   return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
}