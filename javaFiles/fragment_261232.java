public class ObservableLimitedList<T> extends ModifiableObservableListBase<T> {
    private LinkedList<T> list;
    private int maxSize;

    public ObservableLimitedList(int maxSize) {
        this.maxSize = maxSize;
        list = new LinkedList<>();
    }

    @Override
    public boolean add(T element) {
        boolean result = super.add(element);
        if (size() > maxSize) {
            remove(0);
        }
        return result;
    }

    // delegate overrides:

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected void doAdd(int index, T element) {
        list.add(index, element);
    }

    @Override
    protected T doSet(int index, T element) {
        return list.set(index, element);
    }

    @Override
    protected T doRemove(int index) {
        return list.remove(index);
    }
}