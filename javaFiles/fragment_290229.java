private static final int REQUEST_CAMERA_PERMISSION = 1;

     void checkPremission() {
            //select which permission you want
            final String permission = Manifest.permission.CAMERA;
                // if in fragment use getActivity()
            if (ContextCompat.checkSelfPermission(ActivityName.this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(ActivityName.this, permission)) {

                } else {
                    ActivityCompat.requestPermissions(ActivityName.this, new String[]{permission}, REQUEST_CAMERA_PERMISSION);
                }
            } else {
                // you have permission go ahead

            }
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            switch (requestCode) {
                case REQUEST_CAMERA_PERMISSION:
                    final int numOfRequest = grantResults.length;
                    final boolean isGranted = numOfRequest == 1
                            && PackageManager.PERMISSION_GRANTED == grantResults[numOfRequest - 1];
                    if (isGranted) {
                        // you have permission go ahead
                    }else{
                        // you dont have permission show toast
                    }
                    break;
                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }