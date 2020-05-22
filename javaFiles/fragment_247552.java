import java.util.*;
import java.util.stream.*;
public class Test {

    public static void main(String[] args) throws Exception {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "foo");
        map.put(2, "bar");
        map.put(3, "baz");
        String result = map.entrySet()
            .stream()
            .map(entry -> entry.getKey() + " - " + entry.getValue())
            .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}