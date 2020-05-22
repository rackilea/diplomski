import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

items.stream()
        .flatMap(m -> m.entrySet().stream())
        .collect(groupingBy(Map.Entry::getKey, summingLong(Map.Entry::getValue)));