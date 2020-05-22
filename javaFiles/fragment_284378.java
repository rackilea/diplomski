InputStream is = urlConn.getInputStream();
try {
  FileOutputStream os = new FileOutputStream(outputFile);
  try {
    byte[] buffer = new byte[2048];
    while (true) {
      int n = is.read(buffer);
      if (n < 0)
        break;
      os.write(buffer, 0, n);
    }
    os.flush();
  } finally {
    os.close();
  }
} finally {
  is.close();
}