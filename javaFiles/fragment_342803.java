public class PairTransformerSupplier<K,V> implements TransformerSupplier<K, V, KeyValue<K, Pair<V,V>>> {

    private String storeName;

    public PairTransformerSupplier(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public Transformer<K, V, KeyValue<K, Pair<V, V>>> get() {
        return new PairTransformer<>(storeName);
    }
}


public class PairTransformer<K,V> implements Transformer<K, V, KeyValue<K, Pair<V, V>>> {
    private ProcessorContext context;
    private String storeName;
    private KeyValueStore<Integer, V> stateStore;

    public PairTransformer(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore<Integer, V>) context.getStateStore(storeName);
    }

    @Override
    public KeyValue<K, Pair<V, V>> transform(K key, V value) {
        // 1. Update the store to remember the last message seen. 
        if (stateStore.get(1) == null) {
            stateStore.put(1, value); return null;
        }
        KeyValue<K, Pair<V,V>> result = KeyValue.pair(key, new Pair<>(stateStore.get(1), value));
        stateStore.put(1, null);
        return result;
    }

    @Override
    public void close() { }

}


public KStream<String, String> sampleStream(StreamsBuilder builder) {
    KStream<String, String> messages = builder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()));
    // 2. Create the state store and register it with the streams builder. 
    KeyValueBytesStoreSupplier store = Stores.persistentKeyValueStore(stateStoreName);
    StoreBuilder storeBuilder = new KeyValueStoreBuilder<>(
            store,
            new Serdes.IntegerSerde(),
            new Serdes.StringSerde(),
            Time.SYSTEM
    );
    builder.addStateStore(storeBuilder);
    transformToPairs(messages);
    return messages;
}

private void transformToPairs(KStream<String, String> messages) {
    // 3. reference the name of the state store when calling transform(...)
    KStream<String, Pair<String, String>> pairs = messages.transform(
            new PairTransformerSupplier<>(),
            stateStoreName
    );
    KStream<String, Pair<String, String>> filtered = pairs.filter((key, value) -> value != null);
    KStream<String, String> serialized = filtered.mapValues(Pair::toString);
    serialized.to(outputTopic);
}