private static final ThreadLocal messages = new ThreadLocal();
private static final ThreadLocal dontIntercept = new ThreadLocal() {
    protected Object initialValue() {
        return Boolean.FALSE;
    }
};