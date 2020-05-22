import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    private static List<List<List<String>>> partitions(List<String> inputSet) {
        List<List<List<String>>> res = new ArrayList<>();
        if (inputSet.isEmpty()) {
            List<List<String>> empty = new ArrayList<>();
            res.add(empty);
            return res;
        }
        // Note that this algorithm only works if inputSet.size() < 31
        // since you overflow int space beyond that. This is true even
        // if you use Math.pow and cast back to int. The original
        // Python code does not have this limitation because Python
        // will implicitly promote to a long, which in Python terms is
        // an arbitrary precision integer similar to Java's BigInteger.
        int limit = 1 << (inputSet.size() - 1);
        // Note the separate variable to avoid resetting
        // the loop variable on each iteration.
        for (int j = 0; j < limit; ++j) {
            List<List<String>> parts = new ArrayList<>();
            List<String> part1 = new ArrayList<>();
            List<String> part2 = new ArrayList<>();
            parts.add(part1);
            parts.add(part2);
            int i = j;
            for (String item : inputSet) {
                parts.get(i&1).add(item);
                i >>= 1;
            }
            for (List<List<String>> b : partitions(part2)) {
                List<List<String>> holder = new ArrayList<>();
                holder.add(part1);
                holder.addAll(b);
                res.add(holder);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (List<List<String>> partitions :
                 partitions(Arrays.asList("a", "b", "c", "d"))) {
            System.out.println(partitions);
        }
    }
}