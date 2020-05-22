public abstract class BaseItemPresenter<T extends MvpView, I extends BaseBackupItem> 
    extends BasePresenter<T> {
    ...
    public abstract void backup(List<I> list);

    public abstract void delete(List<I> list);

    public abstract void restore(List<I> list);

    ...
}