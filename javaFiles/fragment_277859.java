import java.util.*;

public class Test {

    private static String[] val1 = {
            "q", "w", "e", "r", "t", "y"
    };

    private static String[] val2 = {
            "u", "i", "o", "p", "[", "]"
    };

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("foo", Arrays.asList(val1));
        map.put("bar", Arrays.asList(val2));

        System.out.println(map.get("foo"));
        System.out.println(map.get("bar"));
    }
}