if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
    Intent i = new Intent(Settings.ACTION_APPLICATION_SETTINGS, Uri.parse("package:" + getPackageName()));
    finish();
    startActivity(i);
    return;
}