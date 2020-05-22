@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode==123 && resultCode==RESULT_OK) {
        Uri selectedfile = data.getData(); //The uri with the location of the file
        if (selectedfile != null) {
           Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedfile);
        }
    }
}