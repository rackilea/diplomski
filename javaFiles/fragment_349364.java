public <T> void convert(String string, Class<T> resultClass, Listener<T> listener) {
    try {
        listener.onReady(resultClass.newInstance());
    } catch (IllegalAccessException e) {
    } catch (InstantiationException e) {
    }
}