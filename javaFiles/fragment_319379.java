public static String unescape(String s) {
    StringBuilder r = new StringBuilder();
    for (int i = 0; i < s.length();) {
        if (s.charAt(i) == '%') {
            if (looksLikeUnicode(s, i)) {
                r.append((char) fromHex(s, i + 2, i + 5));
                i += 6;
                continue;
            }
            if (looksLikeAscii(s, i)) {
                r.append((char) fromHex(s, i + 1, i + 2));
                i += 3;
                continue;
            }
        }
        r.append(s.charAt(i));
        i += 1;
    }
    return r.toString();
}

private static boolean looksLikeUnicode(String s, int i) {
    return (i + 5 < s.length()) && (s.charAt(i + 1) == 'u') && areHexDigits(s, i + 2, i + 5);
}

private static boolean looksLikeAscii(String s, int i) {
    return (i + 2 < s.length()) && areHexDigits(s, i + 1, i + 2);
}

private static boolean areHexDigits(String s, int from, int to) {
    for (int i = from; i <= to; ++i) {
        if (isNotHexDigit(s.charAt(i))) {
            return false;
        }
    }
    return true;
}

private static boolean isHexDigit(char c) {
    return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
}

private static boolean isNotHexDigit(char c) {
    return !isHexDigit(c);
}

private static int fromHex(String s, int from, int to) {
    return Integer.parseInt(s.substring(from, to + 1), 16);
}