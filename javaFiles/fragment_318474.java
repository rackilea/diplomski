@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode==123 && resultCode==RESULT_OK) {
        Uri selectedfile = data.getData(); //The uri with the location of the file
        if (selectedfile != null) {
           Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedfile);

           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  
           bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
           byte[] byteArray = outputStream.toByteArray();

           //Use your Base64 String as you wish
           String encodedString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
    }
}