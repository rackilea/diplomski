public static String compress(String str) throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream(str.length());
    GZIPOutputStream gos = new GZIPOutputStream(os);
    gos.write(str.getBytes());
    os.close();
    gos.close();
    return Base64.encodeToString(os.toByteArray(),Base64.DEFAULT);
  }