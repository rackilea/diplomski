public class SubArrayList<T> extends ArrayList<T> {
    public SubArrayList(List<T> parentList, int start, int end) {
        ...;
    }

    @Override
    public T remove(int index) {
        T removed = super.remove(index);
        // should not remove by position because position in parent might change
        parentList.remove(removed);
        return removed;
    }

    @Override
    public T remove(Object obj) {
        if (super.remove(obj)) {
            parentList.remove(obj);
        }
    }
}