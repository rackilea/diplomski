File file = new File("/some/file/path.txt");
if (file.createNewFile()) {
  // Succesfully created a new file
  FileOutputStream fos = new FileOutputStream(file);
  try {
    // Do something with outputstream
  } finally {
    try { fos.close(); } catch (IOException exception) { }
  }
}