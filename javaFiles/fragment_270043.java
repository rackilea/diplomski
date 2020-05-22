@Override
public void onActivityResult(int requestCode, int resultCode, Intent data){

    if(resultCode == RESULT_OK && data != null && data.getData() != null ){

    switch(requestCode){

        case PICK_IMAGE_REQUEST:
            //get filepath from the result of image selection
            Uri filePath = data.getData();
            //Start activity for result for crop for selected image
            startCropActivity(filePath);
            break;

        case PIC_CROP:
            // get the returned data
            Bundle extras = data.getExtras();
            // get the cropped bitmap
            Bitmap selectedBitmap = extras.getParcelable("data");
            //do whatever with the bitmap of the image
            break;

            }
        }
}