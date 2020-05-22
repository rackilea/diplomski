@Override
public void onRequestPermissionsResult(int requestCode,
                                       String permissions[], int[] grantResults) {
    switch (requestCode) {
        case 1: {
            if (!(grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(addAlarm.this, "Permission denied to access your location.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}