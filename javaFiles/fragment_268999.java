public abstract class BaseListActivity<T> extends ListViewActivity {
    private List<T> mItems; 

    protected abstract List<T> readAllFromXML();
    ...

}