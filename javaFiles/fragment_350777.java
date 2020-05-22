public class Cmp<K extends Comparable<K>, V> implements Comparator<Pair<K, V>> {
   @Override
   public int compare(Pair<K, V> o1, Pair<K, V> o2) {
      return o1.k.compareTo(o2.k);
   }
}

public class Utils {
    public static <K extends Comparable<K>, V> Collection<Pair<K, V>> sortPairCollection(
            Collection<Pair<K, V>> col) {
        ArrayList<Pair<K, V>> list = new ArrayList<>();
        Collections.sort(list, new Cmp<>());
        return list;
    }
}