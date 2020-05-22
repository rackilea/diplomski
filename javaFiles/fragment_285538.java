abstract public class AbstractClass<T> {
    private final List<T> list;

    public AbstractClass(List<T> list) {
        this.list = list;
    }

    public List<T> getList() { return list; }
    abstract void addToList(List<T> list);
}