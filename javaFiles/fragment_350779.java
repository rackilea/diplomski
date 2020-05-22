public class Utils {
    public static <K extends Comparable<K>, V> Collection<Pair<K, V>> sortPairCollection(Collection<Pair<K, V>> col) {
        ArrayList<Pair<K, V>> list = new ArrayList<>();
        Collections.sort(list, (p, o) -> p.k.compareTo(o.k));
        return list;
    }
}