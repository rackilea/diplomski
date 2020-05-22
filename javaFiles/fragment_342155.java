try {

  mediaStorageDir2.createNewFile();

  FileOutputStream ostream = new FileOutputStream(mediaStorageDir2);
  photo.compress(CompressFormat.PNG, 10, ostream);
  ostream.flush();
  ostream.close();

  System.gc();

  } catch (Exception e) {
    e.printStackTrace();
}