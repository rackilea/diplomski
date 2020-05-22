public class SuccessCallbackAction<T> extends CallBackAction<T> {

    public SuccessCallbackAction(ServiceCallBack<T> callback) {
        super(callback);
    }

    @Override
    public void call(T target) {
        getCallback().onSuccess(target);
    }
}