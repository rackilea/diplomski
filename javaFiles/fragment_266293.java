public abstract class AsyncCall<T> implements AsyncCallback<T> {

    /** Call the service method using cb as the callback. */
    protected abstract void callService(AsyncCallback<T> cb);

    public void go(int retryCount) {
        showLoadingMessage();
        execute(retryCount);
    }

    private void execute(final int retriesLeft) {
        callService(new AsyncCallback<T>() {
            public void onFailure(Throwable t) {
                GWT.log(t.toString(), t);
                if (retriesLeft <= 0) {
                    hideLoadingMessage();
                    AsyncCall.this.onFailure(t);
                } else {
                    execute(retriesLeft - 1);
                }
            }
            public void onSuccess(T result) {
                hideLoadingMessage();
                AsyncCall.this.onSuccess(result);
            }
        });
    }

    public void onFailure(Throwable t) {
        // standard error handling
    }
    ...
}