public static String moveHighestToTheBeginning(String s) {
    if (s.length() <= 1)
        return s;
    if (s.length() == 2)
        return s.charAt(0) < s.charAt(1) ? String.valueOf(s.charAt(1)) + s.charAt(0) : s;

    String prefix = s.substring(0, s.length() - 1);
    String res = moveHighestToTheBeginning(prefix);
    return s.charAt(s.length() - 1) > res.charAt(0) ? s.charAt(s.length() - 1) + prefix : res + s.charAt(s.length() - 1);
}