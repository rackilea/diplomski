public static class MyContext extends Context {

    private Exception _exception;

    @Override
    protected void doStart() throws Exception {
        try {
            super.doStart();
        } catch (final Exception e) {
            _exception = e;
        }
    }

    @Override
    protected void doStop() throws Exception {
        try {
            super.doStop();
        } finally {
            _exception = null;
        }
    }

    public Exception getException() {
        return _exception;
    }

}

public static class MyServer extends Server implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        start();

        for (final Handler h : getHandlers()) {
            if (h instanceof MyContext) {
                final MyContext c = (MyContext) h;
                if (c.getException() != null) {
                    throw new RuntimeException("failed to init context " + c.getDisplayName(),
                            c.getException());
                }
            }
        }
    }
}