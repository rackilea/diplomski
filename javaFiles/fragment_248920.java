import java.util.*;

import static java.util.Arrays.asList;

public class MegaSolution {

    private static final List<String> matchers = asList("aaaa", "bbbb", "cccc", "dddd");

    public static void main(String[] args) {
        final List<String> input = Arrays.asList("aaaa", "fadsfasfd", "bbbb", "bbbb100500", "ccccfasdfs", "cccc12", "100400");
        input.stream()
                .filter(MegaSolution::matches)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    public static boolean matches(String source) {
        for (String matcher : matchers) {
            if (source != null && source.contains(matcher)) {
                return true;
            }
        }
        return false;
    }
}