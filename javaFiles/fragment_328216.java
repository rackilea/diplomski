@SuppressWarnings("unchecked")
private static final Callback NOP = new Callback() {
    @Override
    public void callback(final Object data) {
        // do nothing
    }
};

@SuppressWarnings("unchecked")
public static final <T> Callback<T> nop() {
    return (Callback<T>) NOP;
}