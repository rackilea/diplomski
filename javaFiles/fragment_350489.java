public static String pad(String in, int len) {
    StringBuilder sb = new StringBuilder(len);
    sb.append(in);
    for (int i = in.length(); i < len; i++) {
        sb.append(' ');
    }
    return sb.toString();
}