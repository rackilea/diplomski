int newMethod1(final String data) {
    final int len = data.length();
    final char[] copy = data.toCharArray();
    for (int i = 0; i < len; i++) {
        if (copy[i] <= ' ') {
            doThrow();
        }
    }
    return len;
}