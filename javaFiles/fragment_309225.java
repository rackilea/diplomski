public class Set<E> implements Collection<E> {

    private ArrayList<E> list = new ArrayList<>();
    ...
    @Override
    public String toString() {
        return list.toString();
    }
}