public static void copyStream(InputStream input, OutputStream output)
    throws IOException {
  byte[] buffer = new byte[1024 * 16]; // Reasonable general size

  int bytesRead;
  while ((bytesRead = in.read(buffer, 0, buffer.length)) != -1) {
    outStream.write(buffer, 0, bytesRead);
  }
}