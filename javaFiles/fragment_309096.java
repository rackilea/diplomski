public interface Set<E> {
    int size(); // determine size of the set
    boolean isEmpty(); // determine if the set is empty or not
    void add(E data); // add to the set
    boolean remove(E data); // remove from the set
    boolean contains(E data); // determine if set holds something
}