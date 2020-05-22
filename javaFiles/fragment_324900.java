import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class Test {

    static Multimap<Integer, String> x = HashMultimap.create();

    public static void main(String[] args) {
        x.put(1, "a");
        x.put(1, "b");
        x.put(2, "d");
        x.put(3, "e");
        x.put(3, "f");
        x.put(4, "a");
        x.put(5, "b");
        x.put(5, "c");

        System.out.println(TestIt.getEntrySetsForValues(x,
                Sets.newHashSet("a", "c")));
    }
}