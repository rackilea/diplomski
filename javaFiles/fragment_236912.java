public class Pair<K extends  Comparable<K>, V> implements Comparable {

    private final K first;

    private final V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public int compareTo(K other) ; // TODO
}