public String inputStreamToString(InputStream in) throws IOException {
    StringBuilder out = new StringBuilder();
    char[] chars = new char[1024];
    Reader reader = new InputStreamReader(in /*, CHARSET_TO_USE */);

    try {
        for (int len; (len = reader.read(chars)) > 0; )
            out.append(chars, 0, len);
    } finally {
        try {
            in.close();
        } catch (IOException ignored) {
        }
    }
    return out.toString();
}