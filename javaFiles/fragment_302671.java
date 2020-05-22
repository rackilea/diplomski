public static String readStream(InputStream is) {
    StringBuilder sb = new StringBuilder(512);
    try {
        Reader r = new InputStreamReader(is, "UTF-8");
        int c = 0;
        while ((c = r.read()) != -1) {
            sb.append((char) c);
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return sb.toString();
}