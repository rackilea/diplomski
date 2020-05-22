public abstract class InjectedDetachableModel<T> extends LoadableDetachableModel<T> {

    public InjectedDetachableModel() {
        Injector.get().inject(this);
    }

    public InjectedDetachableModel(T a_entity) {
        super(a_entity);
        Injector.get().inject(this);
    }
}