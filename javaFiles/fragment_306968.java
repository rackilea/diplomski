public static void throwRuntimeExceptionFromThrowable(Throwable e) {
    if (e == null) {
        return;
    } else if (e instanceof RuntimeException) {
        throw (RuntimeException) e;
    } else if (e instanceof Error) {
        throw (Error) e;
    } else {
        throw new RuntimeException(e.getMessage(), e);
    }
}