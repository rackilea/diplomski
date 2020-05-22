int reuseBuffMethod(final char[] reusable, final String data) {
    final int len = data.length();
    data.getChars(0, len, reusable, 0);
    for (int i = 0; i < len; i++) {
        if (reusable[i] <= ' ') {
            doThrow();
        }
    }
    return len;
}