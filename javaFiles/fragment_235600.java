private static String readInput(String jtext) {
    byte[] bytes = jtext.getBytes();
    try {
        String string = new String(bytes, "UTF-8");
        return string;
    } catch (UnsupportedEncodingException ex) {
        // do something
        return null;
    }
}