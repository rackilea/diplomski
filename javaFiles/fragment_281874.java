@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // if the result is capturing Image
    if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
        if (resultCode == RESULT_OK) {

            // successfully captured the image
            // launching upload activity
            launchUploadActivity(true);


        } else if (resultCode == RESULT_CANCELED) {

            // user cancelled Image capture
            Toast.makeText(getApplicationContext(),
                    "User cancelled image capture", Toast.LENGTH_SHORT)
                    .show();

        } else {
            // failed to capture image
            Toast.makeText(getApplicationContext(),
                    "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    if (requestCode == 2) {
        if (resultCode == PAGE_INTO_LIVENESS) {

            Bundle extras = getIntent().getExtras();
            byte[] face = extras.getByteArray("image_best");

            viewImage();
//automatically upload to server
            try {
                new UploadFileToServer(Config.IMAGE_DOC, Config.IMAGE_FACE).execute();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if (resultCode == RESULT_CANCELED) {

            // user cancelled recording
            Toast.makeText(getApplicationContext(),
                    "User cancelled video recording", Toast.LENGTH_SHORT)
                    .show();
        }
    }

}