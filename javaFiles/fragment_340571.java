int newMethod2(final String data) {
    for (final char c : data.toCharArray()) {
        if (c <= ' ') {
            doThrow();
        }
    }
    return data.length();
}