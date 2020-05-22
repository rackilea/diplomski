import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
....

List<Double> speeds = ...;
Map<Integer, Long> histogram = speeds.stream()
               .collect(groupingBy(Double::intValue, counting()));