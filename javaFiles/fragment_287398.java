File f = new File("file");
if (f.isFile() && f.canRead()) {
  try {
    // Open the stream.
    FileInputStream in = new FileInputStream(f);
    // To read chars from it, use new InputStreamReader
    // and specify the encoding.
    try {
      // Do something with in.
    } finally {
      in.close();
    }
  } catch (IOException ex) {
    // Appropriate error handling here.
  }
}