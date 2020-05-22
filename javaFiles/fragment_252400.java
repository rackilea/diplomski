import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Filtering {

    public static void main(String[] args) {
        // a list of strings
        List<String> strings = new ArrayList<>();
        strings.add("foo");
        strings.add("bar");
        strings.add("baz");

        // a quick and dirty way of representing if a string is enabled
        HashSet<String> disabled = new HashSet<>();
        disabled.add("bar");

        // filter strings to only enabled ones
        strings.stream()
            .filter(s -> !disabled.contains(s))
            .forEach(System.out::println);
    }

}