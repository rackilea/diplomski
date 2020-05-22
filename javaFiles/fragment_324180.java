private final int REQUEST_CAMERA_ID = 123456;

public void setupUI() {

    mButtonEnabled = findViewById(R.id.buttonEnable);
    mButtonEnabled.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] {Manifest.permission.CAMERA}, REQUEST_CAMERA_ID);
        }
    });
}

public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

    switch (requestCode) {
        case REQUEST_CAMERA_ID:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission was granted
            } else {
                    // Permission was denied
            }
        break;
    }
}