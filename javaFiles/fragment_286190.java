int PICK_IMAGE_REQUEST = 100;
int PIC_CROP = 1;

void chooseImageFromGallery() {
    if (isPermissionsGranted(Manifest.permission.READ_EXTERNAL_STORAGE)) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    PICK_IMAGE_REQUEST);
        }
    }
}

 @Override void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
               if (requestCode == PICK_IMAGE_REQUEST && grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {
                chooseImageFromGallery()
               }
    }


@Override void onActivityResult(Int requestCode, Int resultCode, Intent data) {
    if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST) {
        Uri imageUri = data?.data
        performCrop(imageUri)
    }else if(resultCode == Activity.RESULT_OK && requestCode == PIC_CROP){
     // get the returned data
    Bundle extras = data.getExtras();
    // get the cropped bitmap
    Bitmap selectedBitmap = extras.getParcelable("data");

    imgView.setImageBitmap(selectedBitmap);
    }
}

private void performCrop(Uri picUri) {
try {
    Intent cropIntent = new Intent("com.android.camera.action.CROP");
    // indicate image type and Uri
    cropIntent.setDataAndType(picUri, "image/*");
    // set crop properties here
    cropIntent.putExtra("crop", true);
    // indicate aspect of desired crop
    cropIntent.putExtra("aspectX", 1);
    cropIntent.putExtra("aspectY", 1);
    // indicate output X and Y
    cropIntent.putExtra("outputX", 128);
    cropIntent.putExtra("outputY", 128);
    // retrieve data on return
    cropIntent.putExtra("return-data", true);
    // start the activity - we handle returning in onActivityResult
    startActivityForResult(cropIntent, PIC_CROP);
}
// respond to users whose devices do not support the crop action
catch (ActivityNotFoundException anfe) {
    // display an error message
    String errorMessage = "Whoops - your device doesn't support the crop action!";
    Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
    toast.show();
}
}