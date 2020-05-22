public class CancellableCallback<T> implements Callback<T> {

    private Callback<T> callback;

    private boolean canceled;

    private CancellableCallback() {}

    public CancellableCallback(Callback<T> callback) {
        this.callback = callback;
        canceled = false;
    }

    public void cancel() {
        canceled = true;
        callback = null;
    }

    @Override
    public void success(T o, Response response) {
        if (!canceled) {
            callback.success(o, response);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        if (!canceled) {
            callback.failure(error);
        }
    }
}