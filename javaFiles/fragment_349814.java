private static String decode(String myString) {
    byte[] utf8Bytes = null;
    String convertedString = null;
    try {
        utf8Bytes = myString.getBytes("UTF8");
        convertedString = new String(utf8Bytes, "UTF8");
        return convertedString;
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        return "";
    }
}