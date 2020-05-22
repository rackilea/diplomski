public static String increment(String s) {
    StringBuilder sb = new StringBuilder(s);

    boolean done = false;
    for (int i = sb.length() - 1; !done && i >= 0; --i) {
        char c = sb.charAt(i);
        if (c == 'z') {
            c = 'a';
        } else {
            c++;
            done = true;
        }
        sb.setCharAt(i, c);
    }

    if (!done) {
        sb.insert(0, 'a');
    }

    return sb.toString();
}