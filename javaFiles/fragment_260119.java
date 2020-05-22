package casino;

public interface Container<E> {
    E peek();
    E draw();
    boolean insert(E element);
    void insertAt(int index, E element);
    void shuffle();
    void sort();
}