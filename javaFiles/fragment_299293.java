import java.util.HashMap;
import java.util.Map;
import java.util.IntStream;

import static java.util.Comparator.naturalOrder;

public class Solution {
    public static int smallestMode(int input[]) {
        Map<Integer, Integer> counters = new HashMap<>();
        for (Integer i : input) {
            Integer counter = counters.get(i);
            counters.put(i, counter == null ? 1 : counter + 1);
        }

        int mode = Integer.MIN_VALUE;
        for (int counter : counters.values()) mode = Math.max(mode, counter);

        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : counters.entrySet()) {
            if (entry.getValue() == mode) result = Math.min(result, entry.getKey());
        }

        return result;
    }

    public static int smallestModeJava8(int input[]) {
        Map<Integer, Long> counters = IntStream.of(input).boxed().collect(groupingBy(identity(), counting()));
        long mode = counters.values().stream().max(naturalOrder()).get();
        return counters.entrySet().stream().filter(entry -> entry.getValue() == mode).map(Map.Entry::getKey).min(naturalOrder()).get();
    }

    public static void main(String[] args) {
        int[] input = {27, 15, 15, 11, 27};
        System.out.println(smallestMode(input));
        System.out.println(smallestModeJava8(input));
    }
}