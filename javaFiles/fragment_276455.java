private void getImageFromAlbum(){
    try{
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }catch(Exception exp){
        Log.i("Error",exp.toString());
    }
}