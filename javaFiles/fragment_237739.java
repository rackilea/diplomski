// Declare K and V as generic type parameters to ScoreComparator
class ScoreComparator<K, V extends Comparable<V>> 

// Let your class implement Comparator<T>, binding Map.Entry<K, V> to T
implements Comparator<Map.Entry<K, V>> {
    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {

        // Call compareTo() on V, which is known to be a Comparable<V>
        return o1.getValue().compareTo(o2.getValue());
    }   
}