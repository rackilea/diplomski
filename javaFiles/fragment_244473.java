@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
        case 1: {
          ...
          // This will throw error because you
          connectedActivity.showAlertForPermission(FilesActivity.this);

        }
    }
}