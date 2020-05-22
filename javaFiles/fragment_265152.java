private static String format(String s) {
    if (s.length() <= 3)
        return s;
    int first = (s.length() - 1) % 3 + 1;
    StringBuilder buf = new StringBuilder(s.substring(0, first));
    for (int i = first; i < s.length(); i += 3)
        buf.append('.').append(s.substring(i, i + 3));
    return buf.toString();
}