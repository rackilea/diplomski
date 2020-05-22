import java.util.List;
import java.util.stream.Collectors;

public class StackoverflowDemo {

    public static List<String> getDistinctValuesFrom(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }
}