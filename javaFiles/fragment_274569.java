Intent intent = new Intent();
intent.setAction(Intent.ACTION_GET_CONTENT);
intent.setType("file/*");

Intent chooser = Intent.createChooser(sendIntent, "Title");


// Verify that the intent will resolve to an activity
if (intent.resolveActivity(getPackageManager()) != null) {
   startActivityForResult(chooser, 1);
 }