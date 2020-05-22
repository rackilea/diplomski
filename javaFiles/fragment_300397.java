public class FutureResult<T> implements AsyncCallback<T> {
    private enum State {
        SUCCEEDED, FAILED, INCOMPLETE;
    }

    private State state = State.INCOMPLETE;
    private LinkedHashSet<AsyncCallback<T>> listeners = new LinkedHashSet<AsyncCallback<T>>();
    private T value;
    private Throwable error;

    public T get() {
        switch (state) {
        case INCOMPLETE:
            // Do not block browser so just throw ex
            throw new IllegalStateException("The server response did not yet recieved.");
        case FAILED: {
            throw new IllegalStateException(error);
        }
        case SUCCEEDED:
            return value;
        }
        throw new IllegalStateException("Something very unclear");
    }

    public void addCallback(AsyncCallback<T> callback) {
       if (callback == null) return;
       listeners.add(callback);
    }

    public boolean isDone() {
        return state == State.SUCCEEDED;
    }

    public void onFailure(Throwable caught) {
        state = State.FAILED;
        error = caught;
        for (AsyncCallback<T> callback : listeners) {
            callback.onFailure(caught);
        }
    }

    public void onSuccess(T result) {
        this.value = result;
        state = State.SUCCEEDED;
        for (AsyncCallback<T> callback : listeners) {
            callback.onSuccess(value);
        }
    }

}