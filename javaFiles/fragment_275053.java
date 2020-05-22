public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
   super.onRequestPermissionsResult(requestCode, permissions, grantResults);

   if(requestCode == STORAGE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED){
       savePicturePermitted();
   } else {

       Toast.makeText(this, "Permission required", Toast.LENGTH_SHORT).show();
   }