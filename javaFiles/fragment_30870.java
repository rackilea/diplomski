private static String toUnicodeString(String str) {
    String ret = "";
    for (char ch: str.toCharArray())
        ret += String.format("\\u%04x", (int) ch);
    return ret;
}