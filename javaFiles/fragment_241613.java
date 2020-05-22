public class RerunDebugModifier implements IRetryAnalyzer {

    boolean retried = false;

    @Override
    public boolean retry(final ITestResult result) {

        // do we need to retry?
        // 1st time YES -> retry with DEBUG level
        if (!this.retried) {
            Configurator.setRootLevel(Level.DEBUG);
            this.retried = true;
            return true;

        } else {
            // 2nd time NO -> reset to ERROR, don't retry
            Configurator.setRootLevel(RerunBeforeSuiteOnlyError.DEFAULT_TEST_LOGGING_LEVEL);

            return false;
        }

    }
}