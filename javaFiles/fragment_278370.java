import java.util.*;
public class MapExample {
    public static void main(String[] args) {
        populateThenDump(new HashMap<String,Integer>());
        populateThenDump(new TreeMap<String,Integer>());
        populateThenDump(new LinkedHashMap<String,Integer>());
    }
    static void populateThenDump(Map<String,Integer> map) {
        System.out.println(map.getClass().getName());

        map.put("Zero",  0);
        map.put("One",   1);
        map.put("Two",   2);
        map.put("Three", 3);
        map.put("Four",  4);

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}