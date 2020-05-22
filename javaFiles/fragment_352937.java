private static final int FileChooserRequestCode = 666;

Intent intent = new Intent(this, FileChooser.class);
startActivityForResult(intent, FileChooserRequestCode);

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   if (requestCode == FillChooserRequestCode) {
     if (resultCode == Activity.RESULT_OK) {
          //  ... file is chosen
          String fileName = data.getStringExtra("FileName");    
     } else {

           ... dialog is closed

     }

   }
}