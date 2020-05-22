public class Pair<K extends Comparable<K>, V> implements Comparable<Pair<K, V>> {
    private K k;
    private V v;
    @Override
    public int compareTo(Pair<K, V> o) {
        return k.compareTo(o.k);
    }
}
public class Utils {
    public static <K extends Comparable<K>, V> Collection<Pair<K, V>> sortPairCollection(Collection<Pair<K, V>> col) {
        ArrayList<Pair<K, V>> list = new ArrayList<>();
        Collections.sort(list);
        return list;
    }
}