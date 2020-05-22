int fieldMethod1(final Field field, final String data) {
    try {
        final char[] chars = (char[]) field.get(data);
        final int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] <= ' ') {
                doThrow();
            }
        }
        return len;
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}