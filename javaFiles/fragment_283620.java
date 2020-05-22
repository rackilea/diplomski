import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SplitWordCount
{
    public static void main(String[] args)
    {
        List<String> terms = Arrays.asList(
            "Coding is great",
            "Search Engines are great",
            "Google is a nice search engine");

        Map<String, Integer> result = terms.parallelStream().
            flatMap(s -> Arrays.asList(s.split(" ")).stream()).
            collect(Collectors.toConcurrentMap(
                w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println(result);
    }
}