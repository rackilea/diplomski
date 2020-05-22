static {
    try {
        FOO = getItSomehow();
    } catch (Exception e) {
        throw new ExceptionInInitializerError(e);
    }
}