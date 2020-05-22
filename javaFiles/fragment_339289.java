@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // Check which request we're responding to
    if (requestCode == YOUR_REQUEST_CODE) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {

            // Do something with here.
        }
    }
}