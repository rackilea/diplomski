import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;


public static List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Long> freq = Arrays.stream(nums).boxed()
            .collect(groupingBy(x->x, counting()));

    return freq.entrySet()
            .stream()
            .sorted(comparingByValue(reverseOrder()))
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(toList());
}