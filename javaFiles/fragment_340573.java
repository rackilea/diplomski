int fieldMethod2(final Field field, final String data) {
    final char[] chars;
    try {
        chars = (char[]) field.get(data);
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
    for (final char c : chars) {
        if (c <= ' ') {
            doThrow();
        }
    }
    return chars.length;
}