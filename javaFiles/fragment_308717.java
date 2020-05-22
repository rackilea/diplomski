public static class Retry implements TestRule {

    private final int retryCount;

    public Retry(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public Statement apply(final Statement base,
            final Description description) {
        return new Statement() {

            @Override
            @SuppressWarnings("synthetic-access")
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;
                int failuresCount = 0;
                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        System.err.println(description.getDisplayName()
                            + ": run " + (i + 1) + " failed:");
                        t.printStackTrace();
                        ++failuresCount;
                    }
                }
                if (caughtThrowable == null) return;
                throw new AssertionError(description.getDisplayName()
                        + ": failures " + failuresCount + " out of "
                        + retryCount + " tries. See last throwable as the cause.", caughtThrowable);
            }
        };
    }
}