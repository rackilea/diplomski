import java.util.Collection;
import java.util.Map.Entry;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

public class TestIt {

    public static Iterable<Entry<Integer, String>> getEntrySetsForValues(
            Multimap<Integer, String> fromMap, final Collection<String> values) {
        return Iterables.filter(fromMap.entries(),
                new Predicate<Entry<Integer, String>>() {
                    @Override
                    public boolean apply(Entry<Integer, String> arg0) {
                        return values.contains(arg0.getValue());
                    }
                });
    }
}