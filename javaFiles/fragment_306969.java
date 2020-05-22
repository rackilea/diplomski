public Object someMethod() {
    try {
        return getTheObject();
    } catch (Exception e) {
        throwRuntimeExceptionFromThrowable(e);
    }
}