public void init() {
    AccessController.doPrivileged(new PrivilegedAction<Object> {
        @Override public Object run() {
            // Put your original init() here.
            return null;
        }
    });
}