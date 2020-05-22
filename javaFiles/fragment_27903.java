public class JavaFXMockMaker implements MockMaker {

    private final MockMaker wrapped = new CglibMockMaker();
    private boolean jfxIsSetup;

    private void doOnJavaFXThread(Runnable pRun) throws RuntimeException {
        if (!jfxIsSetup) {
            setupJavaFX();
            jfxIsSetup = true;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Platform.runLater(() -> {
            pRun.run();
            countDownLatch.countDown();
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void setupJavaFX() throws RuntimeException {
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            new JFXPanel(); // initializes JavaFX environment
            latch.countDown();
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T createMock(MockCreationSettings<T> settings, MockHandler handler) {
        AtomicReference<T> result = new AtomicReference<>();
        Runnable run = () -> result.set(wrapped.createMock(settings, handler));
        doOnJavaFXThread(run);
        return result.get();
    }

    @Override
    public MockHandler getHandler(Object mock) {
        AtomicReference<MockHandler> result = new AtomicReference<>();
        Runnable run = () -> result.set(wrapped.getHandler(mock));
        doOnJavaFXThread(run);
        return result.get();
    }

    @Override
    public void resetMock(Object mock, MockHandler newHandler, @SuppressWarnings("rawtypes") MockCreationSettings settings) {
        Runnable run = () -> wrapped.resetMock(mock, newHandler, settings); 
        doOnJavaFXThread(run);
    }

}