@Rule
public MethodRule watchman = new TestWatchman() {
    @Override
    public void failed(Throwable e, FrameworkMethod method) {
        System.err.println(method.getName() + "() failed with error: " + e.getMessage());
    }

    @Override
    public void succeeded(FrameworkMethod method) {
        System.err.println(method.getName() + "() succeeded");
    }
};