public void refreshMedia(){

 new Handler().postDelayed(new Runnable() {
  @Override
  public void run() {
    MediaScannerConnection.scanFile(ApplicationContext.context, new String[] { imageFile.getPath() }, null,
              new MediaScannerConnection.OnScanCompletedListener() {
                @Override
                public void onScanCompleted(String path, Uri uri) {
                //gallery refreshed.
                  Log.i(TAG, "Scanned " + path);
                }
              });
           }
        }, 1500);  //this is to refresh media after 1.5 second delay

}