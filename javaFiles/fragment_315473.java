import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

...

List<Set<String>> result = 
    strs.stream()
        .collect(collectingAndThen(groupingBy(String::toLowerCase, toSet()), 
                                   m -> new ArrayList<>(m.values())));