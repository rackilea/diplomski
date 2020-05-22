public static String convert(String s) {
    int start = s.indexOf(':') + 1;
    int end = s.indexOf('\t', start);

    return s.substring(0, start)
            + s.substring(start, end).replaceAll(",", "|")
            + s.substring(end, s.length());
}