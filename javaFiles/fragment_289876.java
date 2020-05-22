@Override
    protected void onCreate(Bundle savedInstanceState) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE);
        }
        else{
            readyToStart = true;
        }
    }



@Override
    protected void onResume() {
        super.onResume();
        if (readyToStart) {
            startBluetooth();
        }
    }

@Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults) {
        Log.i("Permission", "Callback made");
        switch (requestCode) {
            case REQUEST_CODE: {
                if (permissions[0].equals(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                        PermissionDialog newDialog = new PermissionDialog();
                        newDialog.show(getSupportFragmentManager(), "Request Location Permission");
                    }
                    else{
                        startBluetooth();
                    }
                }
            }
        }
    }