public static String convertFromUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("ISO-8859-1"), "windows-1251");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }