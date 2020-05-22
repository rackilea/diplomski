import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

IntStream.range(0,list.size())
        .boxed()
        .collect(groupingBy(
                i -> i % 2 == 0 ? "even" : "odd", 
                mapping(list::get, toList())
        ));