import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams {
    public static void main(String... args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("C");
        set.add("A");
        set.add("B");

        Iterator<String> iterator = set.descendingIterator();

        int characteristics = Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED;
        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(iterator, characteristics);

        boolean parallel = false;
        Stream<String> stream = StreamSupport.stream(spliterator, parallel);

        stream.forEach(System.out::println); // prints C, then B, then A
    }
}