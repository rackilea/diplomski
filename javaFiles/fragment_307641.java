@Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);
if (resultCode == RESULT_OK) {
  switch (requestCode) {
    case IMAGE_EDITOR_RESULT:
      Uri editedImageUri = data.getParcelableExtra(AdobeImageIntent.EXTRA_OUTPUT_URI);
      Log.d(TAG, "editedImageUri: " + editedImageUri.toString());
      Bundle extra = data.getExtras();
      if (extra != null) {
        boolean changed = extra.getBoolean(AdobeImageIntent.EXTRA_OUT_BITMAP_CHANGED);
        Log.d(TAG, "Image edited: " + changed);
        if (changed) {
          mEditedImageView.setImageURI(editedImageUri);
        }
      }
      break;

    default:
      throw new IllegalArgumentException("Unexpected request code");
  }
}
}