class MyRule implements TestRule {
    static final AtomicBoolean INITIALIZED = new AtomicBoolean();

    @Override
    public Statement apply(final Statement base, final Description description) {

        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                boolean needsTearDown = false;
                try {
                    if (INITIALIZED.compareAndSet(false, true)) {
                        BeforeAll.run();
                        needsTearDown = true;
                    }
                    base.evaluate();
                } finally {
                    if (needsTearDown) {
                        AfterAll.run();
                        INITIALIZED.set(false);
                    }
                }
            }
        };
    }
}