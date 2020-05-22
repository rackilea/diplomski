private void getWirtePermissionAndCreateDir() {
        if (Build.VERSION.SDK_INT < 23) {            
            createDir();

        } else {
            final String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //Asking request Permissions
            ActivityCompat.requestPermissions(mActivity, PERMISSIONS_STORAGE, 9);
        }
    }   

     @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        boolean writeAccepted = false;
        switch (requestCode) {
            case 9:
                writeAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (writeAccepted) {
           createDir();
        } else {
            Toast.makeText(mActivity, "You don't assign permission.", Toast.LENGTH_LONG).show();
        }
    }

    private void createDir(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_MOVIES), "reelyChat/vids");
        mediaStorageDir.mkdirs();
    }