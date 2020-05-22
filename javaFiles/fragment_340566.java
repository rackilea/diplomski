int charAtMethod2(final String data) {
    for (int i = 0; i < data.length(); i++) {
        if (data.charAt(i) <= ' ') {
            doThrow();
        }
    }
    return data.length();
}