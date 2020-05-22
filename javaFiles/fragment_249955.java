MediaScannerConnection.scanFile(this,
          new String[] { filePath }, null,
          new MediaScannerConnection.OnScanCompletedListener() {
      @Override
      public void onScanCompleted(String path, Uri uri) {
          Log.i("ExternalStorage", "Scanned " + path + ":");
          Log.i("ExternalStorage", "-> uri=" + uri);
      }
});