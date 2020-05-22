import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Map.Entry<String, String>> list = Arrays.asList(
                Map.entry("a", "b"),
                Map.entry("a", "b"),
                Map.entry("a", "b")
        );
        System.out.println(list);
        List<String> result = list.stream().map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.println(result);
    }
}