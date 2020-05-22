import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {

        Set<Map<Integer, Integer>> sets = new HashSet<Map<Integer, Integer>>();
        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        m1.put(1, 4);
        m1.put(2, 3);
        sets.add(m1);
        Map<Integer, Integer> m2 = new HashMap<Integer, Integer>();
        m2.put(1, 4);
        m2.put(6, 7);
        sets.add(m2);
        System.out.println(sets);

        Map<Integer, Integer> m3 = new HashMap<Integer, Integer>();
        System.out.println(m3+" | "+sets.contains(m3));
        m3.put(6, 7);
        System.out.println(m3+" | "+sets.contains(m3));
        m3.put(1, 4);
        System.out.println(m3+" | "+sets.contains(m3));
    }
}