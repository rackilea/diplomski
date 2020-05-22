abstract class BaseTest {

@Rule
public TestWatcher watchman = new TestWatcher() {
// define logger here

    @Override
    protected void failed(Throwable e, Description description) {
        logger.error(description, e);
    }

    @Override
    protected void succeeded(Description description) {
        logger.info(description);
    }
};