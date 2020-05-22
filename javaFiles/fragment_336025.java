// this works for up to 10 elements:
Map<String, String> test1 = Map.of(
    "a", "b",
    "c", "d"
);

// this works for any number of elements:
import static java.util.Map.entry;    
Map<String, String> test2 = Map.ofEntries(
    entry("a", "b"),
    entry("c", "d")
);