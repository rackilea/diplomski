import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RetainFrequentValues
{
    public static void main(String[] args)
    {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "abc");
        map.put(2, "def");
        map.put(3, "mno");
        map.put(4, "abc");
        map.put(5, "ijk");
        map.put(6, "abc");

        // For testing
        map.put(7, "def");

        Map<Integer, String> result = retainFrequentValues(map);
        result.entrySet().forEach(System.out::println);
    }

    private static <K, V> Map<K, V> retainFrequentValues(Map<K, V> map)
    {
        Map<V, Long> counts = map.values().stream()
            .collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
        Map<K, V> result = map.entrySet().stream()
            .filter(e -> counts.get(e.getValue()) > 1)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        return result;
    }

}