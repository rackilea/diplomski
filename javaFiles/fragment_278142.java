@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

if (requestCode == PICKFILE_REQUEST_CODE ) {
   if(resultCode == Activity.RESULT_OK){
      Uri imageUri = data.getData();     
      Intent intent = new Intent(this, ImageViewer.class);
      intent.putExtra("imageUri", imageUri.toString());
      startActivity(intent); // Start new intent to see the full sized image ImageViewer
    }
}