public abstract class ChainedComparator<T> implements Comparator<T> {

    private Comparator<T> next;

    @Override
    public int compare(T o1, T o2) {
        int result = doCompare(o1, o2);
        if (result == 0) {
            if (getNext() != null) {
                return getNext().compare(o1, o2);
            }
        }

        return result;
    }

    public abstract int doCompare(T o1, T o2);

    public Comparator<T> getNext() {
        return next;
    }

    public void setNext(Comparator<T> next) {
        this.next = next;
    }
}