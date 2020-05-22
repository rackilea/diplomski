public static int firstChineseChar(String s) {
    for (int i = 0; i < s.length(); ) {
        int index = i;
        int codepoint = s.codePointAt(i);
        i += Character.charCount(codepoint);
        if (Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN) {
            return index;
        }
    }
    return -1;
}