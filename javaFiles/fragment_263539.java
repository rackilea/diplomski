import java.util.*;

public class ArraySet<T> {
    private final Map<Integer, T> indexToElem;
    private final Map<T, Integer> elemToIndex;

    public ArraySet() {
        indexToElem = new HashMap<Integer, T>();
        elemToIndex = new HashMap<T, Integer>();
    }

    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return indexToElem.get(index);
    }

    public void add(T elem) {
        if (!contains(elem)) {
            int index = indexToElem.size();
            indexToElem.put(index, elem);
            elemToIndex.put(elem, index);
        }
    }

    // Doesn't work; see comment.
    /*public void remove(T elem) {
        int index = elemToIndex.get(elem);
        indexToElem.remove(index);
        elemToIndex.remove(elem);
    }*/

    public boolean contains(T elem) {
        return elemToIndex.containsKey(elem);
    }

    public int size() {
        return indexToElem.size();
    }
}