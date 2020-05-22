private static String toString(char[] arr) {
    StringBuilder buf = new StringBuilder();
    buf.append('{');
    boolean first = true;
    for (char c: arr) {
        if (first) {
            first = false;
        } else {
            buf.append(',');
        }
        buf.append(c);
    }
    buf.append('}');
    return buf.toString();
}