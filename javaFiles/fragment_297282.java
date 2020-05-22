/** Reads UTF-8 character data; lines are terminated with '\n' */
  public static String readLine(InputStream in) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    while (true) {
      int b = in.read();
      if (b < 0) {
        throw new IOException("Data truncated");
      }
      if (b == 0x0A) {
        break;
      }
      buffer.write(b);
    }
    return new String(buffer.toByteArray(), "UTF-8");
  }