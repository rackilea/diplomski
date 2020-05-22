abstract public class BasePresenter<T extends ViewInterface> {
    protected T view;

    protected T getView() {
        return view;
    }
}