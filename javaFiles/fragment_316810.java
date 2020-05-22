import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

public class TestIterator {

    private static String[] foobarness  =
                                   {
            "foo", "bar", "ness", "foo", "bar", "foo", "ness", "bar", "foo", "ness", "foo", "bar", "foo", "ness",
            "bar", "ness", "foo", "bar", "foo", "ness"
                                   };
    private static String[] types      =
                                   {
            "type::1", "type::2", "type::3", "type::4",
                                   };
    public static void main(String[] args) {
        Map<String, Multiset<String>> typeTextCount = new HashMap<String, Multiset<String>>();

        Multiset<String> textAndCount = TreeMultiset.create();

        for (int i = 0; i < types.length; i++) {
            // I know it's kinda weird but in my task,
            // I want to keep adding only 1 to the count for each entry.
            // Please suggest if there is a better hashmap/list for such task.
            if (("type::1".equals(types[i])) || ("type::3".equals(types[i]))) {
                for (String text : foobarness) {
                    // I don't worry too much about how i
                    // populate the Map, it is iterating through
                    // the Map that I have problem with.
                    textAndCount.add(text, 1);
                }
            }

            if (("type::2".equals(types[i])) || ("type::4".equals(types[i]))) {
                for (String text : foobarness)
                    textAndCount.add(text, 1);
            }
            typeTextCount.put(types[i], textAndCount);
        }

        Iterator<Entry<String, Multiset<String>>> itTTC = typeTextCount.entrySet().iterator();
        while (itTTC.hasNext()) {
            Map.Entry textCt = (Map.Entry) itTTC.next();
            System.out.println(textCt.getKey() + " :\t" + textCt.getValue());
            itTTC.remove();
        }
    }
}