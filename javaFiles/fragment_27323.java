static public void assertSame(Object expected, Object actual) {
    assertSame(null, expected, actual);
}

static public void assertSame(String message, Object expected, Object actual) {
    if (expected == actual) {
        return;
    }
    failNotSame(message, expected, actual);
}