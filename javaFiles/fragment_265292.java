public class MySyncedTreeSet extends TreeSet {
    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return super.contains(o);
    }

    // and the same for all other methods
}