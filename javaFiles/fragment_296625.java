public static boolean isUTF8MB4(String s) {
    for (int i = 0; i < s.length(); ) {
        int codePoint = s.codePointAt(i);
        int bytes = Character.charCount(codePoint);
        if (bytes > 3) {
            return true;
        }
        i += bytes;
    }
    return false;
}