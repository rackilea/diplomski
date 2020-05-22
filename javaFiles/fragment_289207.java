InputStream in = null;
try {
  in = new InputStream(...);
  // do stuff
} catch (IOException e) {
  // do whatever
} finally {
  if (in != null) {
    try {
      in.close();
    } catch (Exception e) {
    }
  }
}