public class LiveIndexMultimap<K, V> implements Multimap<K, V> {
    private final Collection<V> values;
    private final Function<? super V, K> keyFunction;

    public LiveIndexMultimap(Collection<V> values,
                             Function<? super V, K> keyFunction) {
        this.values = values;
        this.keyFunction = keyFunction;
    }

    public Collection<V> get(K key) {
        return FluentIterable.from(values)
                 .filter(Predicates.compose(Predicates.equalTo(key),
                         keyFunction)))
                 .toList(); // Copy needed if you want your example to work
    }

    // Other methods left as an exercice to the reader
}