private static class Container
    <K extends Comparable<? super K>, Value>
    implements Comparable<Container<? extends Comparable<? super K>, ?>>
    {
        public K key;
        public Value value;
        public Container(K k, Value v) {
            key = k;
            value = v;
        }
        public int compareTo(Container<? extends Comparable<? super K>, ?> o) {
            return -o.key.compareTo(key);
        }
    }