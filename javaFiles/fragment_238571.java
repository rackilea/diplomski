private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
    if (resultCode == RESULT_OK) {
        // Image captured and saved to fileUri specified in the Intent
        Toast.makeText(this, "Image saved to:\n" +
                 data.getData(), Toast.LENGTH_LONG).show();
    } else if (resultCode == RESULT_CANCELED) {
        // User cancelled the image capture
    } else {
        // Image capture failed, advise user
    }
}

if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
    if (resultCode == RESULT_OK) {
        // Video captured and saved to fileUri specified in the Intent
        Toast.makeText(this, "Video saved to:\n" +
                 data.getData(), Toast.LENGTH_LONG).show();
    } else if (resultCode == RESULT_CANCELED) {
        // User cancelled the video capture
    } else {
        // Video capture failed, advise user
    }
}
}