public class SortedList<E> extends AbstractList<E> {

    private ArrayList<E> internalList = new ArrayList<E>();

    // Note that add(E e) in AbstractList is calling this one
    @Override 
    public void add(int position, E e) {
        internalList.add(e);
        Collections.sort(internalList, null);
    }

    @Override
    public E get(int i) {
        return internalList.get(i);
    }

    @Override
    public int size() {
        return internalList.size();
    }

}