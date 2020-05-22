void asynchronousMethod(int arg0, String arg1, Callback callback) {
    try {
        int result = doStuff();
    } catch (Throwable t) {
        callback.onFailure(t);
        return;
    }
    callback.onSuccess(result);
}