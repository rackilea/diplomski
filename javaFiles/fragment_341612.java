@Override
protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    switch (requestCode) {
        case PICTURE_GALLERY:
        if (resultCode == RESULT_OK && intent != null) {
            Uri selectedImage = intent.getData();
            final String[] filePathColumn = { MediaColumns.DATA, MediaColumns.DISPLAY_NAME };
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            // some devices (OS versions return an URI of com.android instead of com.google.android
            if (selectedImage.toString().startsWith("content://com.android.gallery3d.provider"))  {
                // use the com.google provider, not the com.android provider.
                selectedImage = Uri.parse(selectedImage.toString().replace("com.android.gallery3d","com.google.android.gallery3d"));
            }
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(MediaColumns.DATA);
                // if it is a picasa image on newer devices with OS 3.0 and up
                if (selectedImage.toString().startsWith("content://com.google.android.gallery3d")){
                    columnIndex = cursor.getColumnIndex(MediaColumns.DISPLAY_NAME);
                    if (columnIndex != -1) {
                        progress_bar.setVisibility(View.VISIBLE);
                        final Uri uriurl = selectedImage;
                        // Do this in a background thread, since we are fetching a large image from the web
                        new Thread(new Runnable() {
                            public void run() {
                                Bitmap the_image = getBitmap("image_file_name.jpg", uriurl);
                            }
                        }).start();
                    }
                } else { // it is a regular local image file
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();
                    Bitmap the_image = decodeFile(new File(filePath));
                }
            }
            // If it is a picasa image on devices running OS prior to 3.0
            else if (selectedImage != null && selectedImage.toString().length() > 0) {
                progress_bar.setVisibility(View.VISIBLE);
                final Uri uriurl = selectedImage;
                // Do this in a background thread, since we are fetching a large image from the web
                new Thread(new Runnable() {
                    public void run() {
                        Bitmap the_image = getBitmap("image_file_name.jpg", uriurl);
                    }
                }).start();
            }
        }
        break;
    }
}