Intent intent = new Intent();
intent.setAction(Intent.ACTION_GET_CONTENT);
intent.setType("file/*");

// Verify that the intent will resolve to an activity
if (intent.resolveActivity(getPackageManager()) != null) {
   startActivityForResult(intent, 1);
 }