String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/MyApp/";
// this provides path to the phone memory available to you, not an external sdcard.
File fileFolder = new File(path);

try {
  // Make sure the Pictures directory exists.
  if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) && !fileFolder.exists()) {
    if (!fileFolder.mkdirs()) {
      Log.i("myApp", "failed to create directory");
    } else {
      Log.i("myApp", "the dir has been created and path : "+ fileFolder.getPath());
    }
  } else {
    Log.i("myApp", "unable to write to external dir");
  }
  newFoto = new File(path, "filename.extension");
  // i don't know what urls[1] is returning so for the moment filename.extension

  URL url = new URL(urls[0]);
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  is = connection.getInputStream();

  OutputStream os = new FileOutputStream(newFoto);

  byte[] buffer = new byte[is.available()];
  int bytesRead = 0;
  while ((bytesRead = is.read(buffer, 0, buffer.length)) != -1) {
    os.write(buffer, 0, bytesRead);
  }

  Log.i("myApp", "writing at" + newFoto.getPath());
  is.close();
  os.close();

  return true;
} catch (IOException e) {
  Log.i("myApp", "Download has failed: " + e);
  return false;
}