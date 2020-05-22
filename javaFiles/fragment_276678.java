if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.CAMERA)
    != PackageManager.PERMISSION_GRANTED) {
  ActivityCompat.requestPermissions(thisActivity,
            new String[]{Manifest.permission.CAMERA},
            0);
}