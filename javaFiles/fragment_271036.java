private String selectedImage;

public void onActivityResult(int requestCode,int resultCode,Intent data) {

    ............//grant permission codes here

    //If it is from gallery
    if (requestCode == 1 && resultCode == RESULT_OK && null != data) {

        ....

        String imgDecodableString = cursor.getString(columnIndex);

        selectedImage = imgDecodableString;
    }

    //If request is from camera
    if (resultCode == Activity.RESULT_OK) {
        selectedImage = cameraFilePath;
    }
}