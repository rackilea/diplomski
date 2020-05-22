private static String transformName(String in) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0, len = in.length(); i < len; i++) {
        char ch = in.charAt(i);
        if (ch == 'A') {
            if (i + 1 < in.length() && in.charAt(i + 1) != 'A') {
                sb.append(in.charAt(i + 1));
                i++;
            }
        }
        sb.append(ch);
    }
    return sb.toString();
}