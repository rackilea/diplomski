boolean isImageSet = false;
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode==Result_Load_Image && resultCode==RESULT_OK && data!=null){

        Uri selectedImage= data.getData();

        userProfilePic.setImageURI(selectedImage);
        isImageSet = true;
    }
}