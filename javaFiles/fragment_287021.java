public class ErrorCallbackAction extends CallBackAction<Object> {
    public ErrorCallbackAction(ServiceCallBack<Object> callback) {
        super(callback);
    }

    @Override
    public void call(Throwable target) {
        getCallback().onError();
    }
}