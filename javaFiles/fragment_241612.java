public class RerunBeforeSuiteOnlyError implements ISuiteListener {

    public static final Level DEFAULT_TEST_LOGGING_LEVEL = Level.ERROR;

    @Override
    public void onStart(final ISuite suite) {
        Configurator.setRootLevel(DEFAULT_TEST_LOGGING_LEVEL);
    }

    @Override
    public void onFinish(final ISuite suite) {

    }
}