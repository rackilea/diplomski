eventListener = new CustomWebDriverEventListener();
driver = new EventFiringWebDriver(driver).register(eventListener);

@Rule
public TestWatcher  watchman = new TestWatcher() {

    protected void failed(Throwable e, Description description) {
        RuntimeException exception = (RuntimeException) e;
        eventListener.onException(e, getDriver());
        if (exception instanceof RuntimeException) {
            throw exception;
        }   
    };
};