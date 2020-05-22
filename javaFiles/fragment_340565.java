int charAtMethod1(final String data) {
    final int len = data.length();
    for (int i = 0; i < len; i++) {
        if (data.charAt(i) <= ' ') {
            doThrow();
        }
    }
    return len;
}