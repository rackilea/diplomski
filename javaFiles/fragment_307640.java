if (extras != null) {
  Uri imageUri = Uri.parse(getIntent().getExtras().getString(IMAGE_URI));
  Intent imageEditorIntent = new AdobeImageIntent.Builder(this).setData(imageUri).build();
  startActivityForResult(imageEditorIntent, IMAGE_EDITOR_RESULT);
 // below line of code is not possible. your trying to receive result over 
  //here.  
 // . but your finishing it before it receives result
finish(); 
}