@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Bitmap bitmap = ImagePicker.getBitmapFromResult(this, resultCode, data);
    if (null != bitmap && resultCode == RESULT_OK) {
    //do what you want with the bitmap here

   }
}