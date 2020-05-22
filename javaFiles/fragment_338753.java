public static String getStringFromStream(InputStream in, String encoding) 
        throws IOException {
    InputStreamReader reader;
    if (encoding == null) {
        // This constructor sets the character converter to the encoding
        // specified in the "file.encoding" property and falls back 
        // to ISO 8859_1 (ISO-Latin-1) if the property doesn't exist.
        reader = new InputStreamReader(in);
    } else {
        reader = new InputStreamReader(in, encoding);
    }

    StringBuilder sb = new StringBuilder();

    final char[] buf = new char[1024];
    int len;
    while ((len = reader.read(buf)) > 0) {
        sb.append(buf, 0, len);
    }

    return sb.toString();
}