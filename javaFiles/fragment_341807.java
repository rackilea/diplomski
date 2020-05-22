import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Counter {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 6, 1, 2, 1, 5, 3, 6, 1, 2, 1, 5 };
        Map<Integer, Integer> frequency = count(arr);

        for (Entry<Integer, Integer> freq : frequency.entrySet()) {
            System.out.printf("%s - %s%n", freq.getKey(), freq.getValue());
        }
    }

    public static Map<Integer, Integer> count(int[] items) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int item : items) {
            map.put(item, 1 + (map.containsKey(item) ? map.get(item).intValue() : 0));
        }
        return map;
    }
}