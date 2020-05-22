public class ThreadedGenericNode<K extends Comparable<K>, V> implements Comparable<ThreadedGenericNode<K, V>> {
    K _key;

    .......

    @Override
    public int compareTo(ThreadedGenericNode<K, V> o) {

        return this._key.compareTo(o._key);
    }
}