public static String moveSmallestToTheEnd(String s) {
    if (s.length() <= 1)
        return s;
    if (s.length() == 2)
        return s.charAt(0) < s.charAt(1) ? String.valueOf(s.charAt(1)) + s.charAt(0) : s;

    String suffix = s.substring(1);
    String res = moveSmallestToTheEnd(suffix);
    return s.charAt(0) < res.charAt(res.length() - 1) ? suffix + s.charAt(0) : s.charAt(0) + res;
}