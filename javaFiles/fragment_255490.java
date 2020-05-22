import java.util.Date;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class DescendingSetTest {
    public static void main(String[] args) {        
        NavigableSet<Map.Entry<Date, String>> set = new TreeSet<Map.Entry<Date, String>>();

        set.add(newEntry(new Date(0), "0000"));
        set.add(newEntry(new Date(700000000000l), "0000"));
        set.add(newEntry(new Date(700000000000l), "9999"));

        for (Map.Entry<Date, String> entry : set.descendingSet())
            System.out.println(entry);
    }

    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map.Entry<K, V> newEntry(K key, V value) {
        return new Entry<K, V>(key, value);
    }

    private static class Entry<K extends Comparable<? super K>, V extends Comparable<? super V>> implements Map.Entry<K, V>, Comparable<Entry<K, V>> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int compareTo(Entry<K, V> that) {
            int c = key.compareTo(that.key);
            return c != 0 ? c : value.compareTo(that.value);
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object that) {
            return that instanceof Entry<?, ?> ? compareTo((Entry<K, V>)that) == 0 : false;
        }

        @Override
        public String toString() {
            return key + "," + value;
        }
    }
}