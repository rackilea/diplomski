@Override
public void onRequestPermissionsResult(int requestCode,
                                       String permissions[], int[] grantResults) {
    switch (requestCode) {
        case REQUEST_READ_CAMERA: {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission has granted . Call the QR scan Activity
            } else {
                // permission denied
            }
            return;
        }
    }
}