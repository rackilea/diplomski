public static String alphaString(String s1, String s2) {
    int c = s1.compareTo(s2);
    if (c < 0) {
        return s1;
    } else if (c > 0) {
        return s2;
    }
    return "these are the same words";
}