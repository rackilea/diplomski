public class TestRules implements TestRule {
    private int priority = 1; // this value is manually changed to set the priority of tests to run

     public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Priority testCasePriority = desc.getAnnotation(Priority.class);
                Assume.assumeTrue("Test skipped for priotity " + priority, testCasePriority == null || testCasePriority.value() <= priority);

                base.evaluate();
            }
        };
    }
}