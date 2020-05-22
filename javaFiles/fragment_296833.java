import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;
//...

Map<String, Integer> map = new HashMap<>();
map.put("a", 2);
map.put("b", 10);
map.put("c", 5);
map.put("d", 5);
map.put("e", 1);

map.entrySet().parallelStream()
        .sorted(reverseOrder(comparingInt(Map.Entry::getValue)))
        .limit(2)
        .forEach(System.out::println);

//or:   .forEachOrdered(System.out::println);
//to print in descending order