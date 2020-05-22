private final String[] permissions = new String[]{Manifest.permission.CAMERA, 
                                                Manifest.permission.READ_EXTERNAL_STORAGE, 
                                                Manifest.permission.WRITE_EXTERNAL_STORAGE};
private static final int REQUEST_CODE = 12345; //Some random number


...
...

@Override
protected void onCreate(Bundle savedInstanceState) {

    ...

    if (ActivityCompat.checkSelfPermission(SplashScreenActivity.this, permissions[0]) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(SplashScreenActivity.this, permissions[1]) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(SplashScreenActivity.this, permissions[2]) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(SplashScreenActivity.this, permissions, REQUEST_CODE);
    }

    ...
}

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_CODE) {
        if (grantResults.length == 3 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(SplashScreenActivity.this, "Permission granted!!!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(SplashScreenActivity.this, "Necessary permissions not granted...", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}