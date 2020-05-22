public static String inputStreamToString(final InputStream is, final int bufferSize)
{
  final char[] buffer = new char[bufferSize];
  final StringBuilder out = new StringBuilder();
  try {
    final Reader in = new InputStreamReader(is, "UTF-8");
    try {
      for (;;) {
        int rsz = in.read(buffer, 0, buffer.length);
        if (rsz < 0)
          break;
        out.append(buffer, 0, rsz);
      }
    }
    finally {
      in.close();
    }
  }
  catch (UnsupportedEncodingException ex) {
    /* ... */
  }
  catch (IOException ex) {
      /* ... */
  }
  return out.toString();
}