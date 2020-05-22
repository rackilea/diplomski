public abstract class CallBackAction<T> implements Action1<T> {
    private final ServiceCallBack<T> Callback;

    public CallBackAction(ServiceCallBack<T> callback) {
        this.Callback = (null != callback) ? callback : new NullServiceCallBack<>();
    }

    protected ServiceCallBack<T> getCallback() {
        return Callback;
    }
}