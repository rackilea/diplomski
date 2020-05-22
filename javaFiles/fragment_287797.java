import com.google.common.collect.*;

public class GuavaMultiMap {
    public static void main(String [] args) {
        Multimap<Integer, String> map = TreeMultimap.create();
        map.put(0, "-1");
        map.put(1, "a");
        map.put(1, "b");
        map.put(2, "c");
        map.put(2, "d");
        map.put(3, "e");

        SortedMultiset<Integer> keys = TreeMultiset.create();
        keys.addAll(map.keys());

        SortedMultiset<Integer> range = keys.subMultiset(1, BoundType.CLOSED, 3, BoundType.OPEN);
        System.out.println(range.size());
    }
}