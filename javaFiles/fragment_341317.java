protected void onActivityResult(int requestCode, int resultCode, Intent data) {  

   super.onActivityResult(requestCode, resultCode, data); 
   if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){

      Uri selectedImage = data.getData();
      String[] filePathColumn = { MediaStore.Images.Media.DATA };
      Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
      cursor.moveToFirst();
      int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
      String picturePath = cursor.getString(columnIndex);
      cursor.close();
}