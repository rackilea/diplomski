public static String takeOut(String str, char c) {
    int len = str.length();
    StringBuilder newstr = new StringBuilder();
    for (int i = 0; i < len; i++) {
        if (str.charAt(i) != c) {
            newstr.append((char)str.charAt(i));
        }
    }
    return newstr.toString();
}