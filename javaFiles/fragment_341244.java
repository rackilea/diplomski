int PERMISSION_ALL = 1;
String[] PERMISSIONS = new String[0];
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    PERMISSIONS = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION};
}

if (!hasPermissions(getApplicationContext(), PERMISSIONS)) {
    ActivityCompat.requestPermissions(StartupActivity.this, PERMISSIONS, PERMISSION_ALL);
}