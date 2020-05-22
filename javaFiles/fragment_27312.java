static String toXML(String s) {
    Formatter formatter = new Formatter();
    int len = s.length();
    for (int i = 0; i < len; i = s.offsetByCodePoints(i, 1)) {
        int c = s.codePointAt(i);
        if (c < 32 || c > 126 || c == '&' || c == '<' || c == '>') {
            formatter.format("&#x%x;", c);
        } else {
            formatter.format("%c", c);
        }
    }
    return formatter.toString();
}