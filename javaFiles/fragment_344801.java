if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_READ_CAMERA);
    }
    else {
        // Already grant Camera permission. Now call your QR scan Activity
    }
}else {
    // call your QR scan Activity
}