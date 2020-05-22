private static String encoding(String s) {
    char[] arr = s.toCharArray();
    for (char c : arr) {
        if (c >>> 8 != 0) {
            return "UTF16";
        }
    }
    return "Latin1";
}