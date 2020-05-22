public final class ExampleTest {
    public static final class SessionDataManager {
        private static final SessionDataManager instance = new SessionDataManager();
        public static SessionDataManager getInstance() { return instance; }
        public void doSomething() { throw new UnsupportedOperationException("to do"); }
    }

    @Test
    public void mockingASingleton(@Mocked SessionDataManager mockInstance) {
        SessionDataManager singletonInstance = SessionDataManager.getInstance();

        assertSame(mockInstance, singletonInstance);
        singletonInstance.doSomething(); // mocked, won't throw
    }

    @Test
    public void mockingASingletonWithAMockUp() {
        new MockUp<SessionDataManager>() {
            // no point in having a @Mock getInstance() here
            @Mock void doSomething() { /* whatever */ }
        };

        SessionDataManager singletonInstance = SessionDataManager.getInstance();
        singletonInstance.doSomething(); // redirects to the @Mock method, won't throw
    }
}