@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent 
             data) {
                  super.onActivityResult(requestCode, resultCode, data);

         if (requestCode == REQUEST_FOR_GALLARY && resultCode == RESULT_OK && data != 
              null) {

                 Uri imageUri = data.getData();

         CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }
    if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
        CropImage.ActivityResult result = CropImage.getActivityResult(data);

        if (resultCode == RESULT_OK) {


            Uri resultUri = result.getUri();

           //Save image wherever you want to save it 
        }
    }
}