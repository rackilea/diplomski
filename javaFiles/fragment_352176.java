@Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) 
 {
    super.onActivityResult(requestCode, resultCode, data);

if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {

    Uri imageUri = data.getData();
    try {
        Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
        imageView.setImageBitmap(bitmap);
    } catch (IOException e) {
        e.printStackTrace();
      }
   }
}