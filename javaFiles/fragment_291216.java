if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
    if (resultCode == RESULT_OK && null != data) {

        // Image captured and saved to fileUri specified in the Intent
        Toast.makeText(this, "Image saved to:\n" +
                 data.getData(), Toast.LENGTH_LONG).show();
    }