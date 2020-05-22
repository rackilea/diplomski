public class ArraySet<E> extends AbstractSet<E> {
    private final ArrayList<E> list = new ArrayList<>();

    @Override
    public boolean add(E e) {
        if (!list.contains(e)) {
            list.add(e);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }
}