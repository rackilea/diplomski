import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 1, 0, -1, -1);

        Map<Sign, List<Integer>> map = numbers
                .stream()
                .collect(groupingBy(i -> i > 0
                                    ? Sign.POSITIVE
                                    : i < 0 
                                        ? Sign.NEGATIVE
                                        : Sign.ZERO));

        System.out.println(map);
    }
}

enum Sign {POSITIVE, NEGATIVE, ZERO}