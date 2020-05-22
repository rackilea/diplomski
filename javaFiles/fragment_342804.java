class PairTransformerSupplier<K,V> implements TransformerSupplier<K, V, KeyValue<K, Pair<V,V>>> {

    @Override
    public Transformer<K, V, KeyValue<K, Pair<V, V>>> get() {
        return new PairTransformer<>();
    }
}

public class PairTransformer<K,V> implements Transformer<K, V, KeyValue<K, Pair<V, V>>> {
    private V left;

    @Override
    public void init(ProcessorContext context) {
        left = null;
    }

    @Override
    public KeyValue<K, Pair<V, V>> transform(K key, V value) {
        if (left == null) { left = value; return null; }
        KeyValue<K, Pair<V,V>> result = KeyValue.pair(key, new Pair<>(left, value));
        left = null;
        return result;
    }

    @Override
    public KeyValue<K, Pair<V, V>> punctuate(long timestamp) {
        return null;
    }

    public void close() { }

}