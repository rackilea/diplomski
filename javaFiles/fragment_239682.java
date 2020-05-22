AccessController.doPrivileged(new PrivilegedAction() {
    @Override
    public Object run() {
        field.setAccessible(true);
        return null;
    }
});