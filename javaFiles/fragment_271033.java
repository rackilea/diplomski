private ArrayList<String> selectedImages = new ArrayList<>();

public void onActivityResult(int requestCode,int resultCode,Intent data) {

    ............//grant permission codes here

    //If it is from gallery
    if (requestCode == 1 && resultCode == RESULT_OK && null != data) {

        ....

        String imgDecodableString = cursor.getString(columnIndex);

        selectedImages.add(imgDecodableString);
    }

    //If request is from camera
    if (resultCode == Activity.RESULT_OK) {
        selectedImages.add(cameraFilePath);
    }
}