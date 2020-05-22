import java.util.*;

import static java.util.Arrays.asList;

public class MegaSolution {

    private static final List<String> matchers = asList("aaaa", "bbbb", "cccc", "dddd");

    public static void main(String[] args) {
        final List<String> input = Arrays.asList("aaaa", "fadsfasfd", "bbbb", "bbbb100500", "ccccfasdfs", "cccc12", "100400");
        for (String filtered : filter(input)) {
            System.out.println(filtered);
        }
    }

    public static Set<String> filter(Collection<String> input){
        final Set<String> filtered = new TreeSet<>();
        //use linkedHashSet if you want preserve input order and don't want to sort from scratch
        //final Set<String> filtered = new LinkedHashSet<>();
        for (String inputString : input) {
            if (matches(inputString)){
                filtered.add(inputString);
            }
        }
        return filtered;
    }

    public static boolean matches(String source){
        for (String matcher : matchers) {
            if (source != null && source.contains(matcher)){
                return true;
            }
        }
        return false;
    }

}