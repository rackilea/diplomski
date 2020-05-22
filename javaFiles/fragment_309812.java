@FunctionalInterface
private interface ThrowingRunnable <E extends Exception> {
    void run() throws Exception;
}

private Runnable handleNonTestException(ThrowingRunnable<? extends Exception> r) {
    return () -> {
        try {
            r.run();
        } catch (Exception e) {
            logger.error(NON_TEST_EXCEPTION_MSG, e);
            errors.add(new Error(e.getMessage(), NON_TEST_EXCEPTION_MSG));
        }
    };
}`