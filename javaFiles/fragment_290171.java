private void safeFoo(final A a) {
    try {
        a.foo();
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}