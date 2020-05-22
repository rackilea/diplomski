public class FilterByType<T> implements List<T> {

    private List<T> _list;

    public FilterByType(List<T> list) {
        this._list = list;
    }

    public void retainAll(Class<?> c) {
        //..
    }

    public void removeAll(Class<?> c) {
        //..
    }

    // Implement List<T> interface:

    public boolean add(T element) {
        return _list.add(element);
    }

    public void add(int index, T element) {
        _list.add(index, element);
    }

    // etc...

}