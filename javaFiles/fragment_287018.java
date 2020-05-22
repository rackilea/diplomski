public class NullServiceCallBack<T> implements ServiceCallBack<T> {
    @Override
    public void onSuccess(T target) {}

    @Override
    public void onError() {}
}