private static final int REQUEST_STORAGE = 112;

    @Override
        public void onClick(View v) {
        if (v == buttonChoose) {
            if (Build.VERSION.SDK_INT >= 23) {
                String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE};
                if (!hasPermissions(mContext, PERMISSIONS)) {
                    ActivityCompat.requestPermissions((Activity) mContext, PERMISSIONS, REQUEST_STORAGE );
                } else {
                      chooseVideo();
                }
            } else {
                chooseVideo();
            }
        }
        if (v == buttonUpload) {
            uploadVideo();
        }
    }