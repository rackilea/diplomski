public interface MvpView { }

public interface MvpPresenter<V extends MvpView> {
    void attach(V view);
}

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }
}

public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> {
    P presenter;

    protected abstract V getThis();

    public void someMethod() {
        presenter.attach(getThis());
    }

    public P getPresenter() { return presenter; }
}