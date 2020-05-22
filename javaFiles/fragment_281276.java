import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

...

Map<String, String> map = Stream.of(
                new SimpleEntry<>("key1", "value1"),
                new SimpleEntry<>("key2", "value2"))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));