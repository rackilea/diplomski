public static boolean isUTF8MB4(String s) {
    for (int i = 0; i < s.length(); ++i) {
        int bytes = s.substring(i, i + 1).getBytes(StandardCharsets.UTF_8);
        if (bytes > 3) {
            return true;
        }
    }
    return false;
}