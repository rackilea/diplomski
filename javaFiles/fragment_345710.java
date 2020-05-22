import java.util.*;

public class Test {

    public static void main(String[] args) {
        Map<Date, Long> map = new HashMap<Date, Long>();

        map.put(new Date(100), 100L);
        map.put(new Date(400), 400L);
        map.put(new Date(300), 300L);
        map.put(new Date(200), 200L);

        map = reverseChronological(map);
        for (Map.Entry<Date, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey().getTime());
        }
    }    

    public static Map<Date, Long> reverseChronological(Map<Date, Long> input) {
        Map<Date, Long> chronologicalMap =
            new TreeMap<Date, Long>(Collections.reverseOrder());
        chronologicalMap.putAll(input);
        return chronologicalMap;
    }
}