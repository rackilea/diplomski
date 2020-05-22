protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    try {
        // When an Image is picked
        if (requestCode == YOUR_REQUEST_CODE && resultCode == RESULT_OK
                && null != data) {
            // Get the Image from data
            Uri selectedImage = data.getData();

            // Get real path 
            String imageRealPath = getRealPathFromURI(selectedImage);

            // Do something

        }
    } catch (Exception e) {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                .show();
    }

}