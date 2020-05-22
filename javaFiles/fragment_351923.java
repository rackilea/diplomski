public InputStream responseMessage(String message) {
  try {
    return new ByteArrayInputStream(message.getBytes("UTF-8"));
  } catch(UnsupportedEncodingException ex) {
    throw new AssertionError("Every JVM must support UTF-8", ex);
  }
}