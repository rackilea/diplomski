private static String readInput(byte[] bytes) {
    try {
        // change encoding to your DB encoding.
        // this can be UTF-8, UTF-16, 8859_1, etc.
        String string = new String(bytes, "UTF-8");
        return string;
    } catch (UnsupportedEncodingException ex) {
        // do something, at least return garbled text
        return new String(bytes, "UTF-8");;
    }
}