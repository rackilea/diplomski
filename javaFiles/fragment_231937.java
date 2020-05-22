// Open the camera and take a picture
public void openCamera() {
    Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
    getIntent.setType("image/*");
    startActivityForResult(getIntent, SEND_MESSAGE_IMG_REQUEST_IMAGE_PICK);
}

// handle the result from camera
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(requestCode == SEND_MESSAGE_IMG_REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {

        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};

        Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String filePath = cursor.getString(columnIndex);
        cursor.close();

        // do a background task to handle the captured image (upload it to a server or something like that)



    }
}