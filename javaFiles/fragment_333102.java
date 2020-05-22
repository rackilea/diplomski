import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Set;

String csv = "1,2,3,4,,2";
Set<Long> set = Arrays.asList(csv.split(","))
        .stream()
        .map(String::trim)
        .filter(x -> x.length() > 0)
        .map(Long::parseLong)
        .collect(Collectors.toSet());