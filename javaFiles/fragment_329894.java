public class SubListIterator<T> implements Iterator<List<T>>, Iterable<List<T>> {

    public static <C> SubListIterator<C> subList(List<C> given, int itemsEachSubList) {
        return new SubListIterator<C>(given, itemsEachSubList);
    }

    private final List<T> whole;
    private final int elementsEachPart;
    private int fromIndex;
    private int toIndex;

    public SubListIterator(List<T> whole, int itemsEach) {
        this.whole = whole;
        this.elementsEachPart = itemsEach;
        this.fromIndex = 0;
        this.toIndex = elementsEachPart;
    }

    @Override
    public boolean hasNext() {
        return fromIndex < toIndex;
    }

    @Override
    public List<T> next() {
        List<T> nextSubList = whole.subList(fromIndex, toIndex);
        fromIndex = toIndex;
        toIndex = Math.min(toIndex + elementsEachPart, whole.size());
        return nextSubList;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This method is not supported");
    }

    @Override
    public Iterator<List<T>> iterator() {
        return this;
    }

}