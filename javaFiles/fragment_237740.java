class ScoreComparator<V extends Comparable<V>> 
implements Comparator<Map.Entry<?, V>> {
    public int compare(Map.Entry<?, V> o1, Map.Entry<?, V> o2) {

        // Call compareTo() on V, which is known to be a Comparable<V>
        return o1.getValue().compareTo(o2.getValue());
    }   
}