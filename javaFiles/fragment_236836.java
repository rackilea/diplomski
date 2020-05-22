public static String encode(String s) {
    StringBuffer b = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) {
            b.append((char) ((int) c + 13));
            continue;
        }
        if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) {
            b.append((char) ((int) c - 13));
            continue;
        }
        b.append(c);
    }
    return b.toString();
}