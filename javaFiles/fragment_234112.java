public class TreeMap<K2, V2> ... {
    private Comparator<?2 super K2> comp;

    public TreeMap(SortedMap<?3 extends K2, ?4 extends V2> map) {
        this.comp = map.comparator();
        // magic stuff to transfer elements
    }
}