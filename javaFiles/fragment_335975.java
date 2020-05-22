MediaScannerConnection.scanFile(
  context,
  new String[]{file.getAbsolutePath()},
  null,
  new OnScanCompletedListener() {
     @Override
     public void onScanCompleted(String path, Uri uri) {
         // only at this point are files in MediaStore
     }
  });