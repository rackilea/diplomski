public interface CombinedRule extends TestRule {
    default Statement apply(Statement base, Description description) {
        if (description.isTest()) {
            return new Statement() {
                public void evaluate() throws Throwable {
                    before();
                    try {
                        base.evaluate();
                        verify();
                    } finally {
                        after();
                    }
                }
            };
        }
        if (description.isSuite()) {
            return new Statement() {
                public void evaluate() throws Throwable {
                    beforeClass();
                    try {
                        base.evaluate();
                        verifyClass();
                    } finally {
                        afterClass();
                    }
                }
            };
        }
        return base;
    }

    default void before() throws Exception {
        //let the implementer decide whether this method is useful to implement
    }

    default void after() {
        //let the implementer decide whether this method is useful to implement
    }

    /**
     * Only runs for Tests that pass
     */
    default void verify() {
        //let the implementer decide whether this method is useful to implement
    }

    default void beforeClass() throws Exception {
        before();
    }

    default void afterClass() {
        after();
    }

    /**
     * Only runs for Suites that pass
     */
    default void verifyClass() {
        verify();
    }
}