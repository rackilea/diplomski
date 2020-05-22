import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test {
    public static void main(String... args) {
        List<String> names = Arrays.asList("adam", "");
        Stream lengths = names.stream().map(new Function<String, Integer>() {
            public Integer apply(String name) {
                return check(name);
            }
        });
        lengths.count();
    }
    private static int check(String s) {
        if (s.equals(""))
            throw new IllegalArgumentException();
        return s.length();
    }
}