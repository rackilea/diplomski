public class MockitoRule extends TestWatcher {
    private boolean mockInitialized = false;

    @Override
    protected void starting(Description d) {
        if (!mockInitialized) {
            MockitoAnnotations.initMocks(this);
            mockInitialized = true;  
        }
    }
}