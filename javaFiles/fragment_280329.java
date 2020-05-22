public class Table<K, T> extends ForwardingMultimap<K, T> {
    Multimap<K, T> m_map;
    Function<T, K> m_aggKey;
    public Table(Function<T, K> aggKey){
        m_map = HashMultimap.create();
        m_aggKey = aggKey;
    }
    public boolean put(T obj) {
        m_map.put(m_aggKey.apply(obj), obj);
    }
}

public static void main(String[] args) {
    Table<String, CustomObject> IndexOne = new Table<>(x -> x.propertyOne);
    Table<Integer, CustomObject> IndexTwo = new Table<>(x -> x.propertyTwo);
}