private static class MockitoStateCleaner implements Runnable {
    public void run() {
        clearMockProgress();
        clearConfiguration();
    }

    private void clearMockProgress() {
        clearThreadLocalIn(ThreadSafeMockingProgress.class);
    }

    private void clearConfiguration() {
        clearThreadLocalIn(GlobalConfiguration.class);
    }

    private void clearThreadLocalIn(Class<?> cls) {
        Whitebox.getInternalState(cls, ThreadLocal.class).set(null);
        final Class<?> clazz = ClassLoaderUtil.loadClass(cls, ClassLoader.getSystemClassLoader());
        Whitebox.getInternalState(clazz, ThreadLocal.class).set(null);
    }
}