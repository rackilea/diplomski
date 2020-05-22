import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * Create a Map where we already know the keys but computing the values is expensive and so is delayed as 
 * much as possible. 
 *
 */
@AllArgsConstructor
public class MapWithValuesProvidedByFunction implements Map<String, String> {

    /**
     * All keys that are defined.
     */
    private Set<String> keys;

    /**
     * A function which maps a key to its value.
     */
    private Function<String, String> mappingFunction;

    /**
     * Holds all keys and values we have already computed.
     */
    private final Map<String, String> computedValues = new HashMap<>();

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if(computedValues.size() == keys.size()) return computedValues.containsValue(value);
        for(String k : keys) {
            String v = get(k);
            if(v == value) return true;
            if(v != null && v.equals(value)) return true;
        }
        return false;
    }

    @Override
    public String get(Object key) {
        if(keys.contains(key)) {
            return computedValues.computeIfAbsent(key.toString(), mappingFunction);
        }
        return null;
    }

    @Override
    public String put(String key, String value) {
        throw new UnsupportedOperationException("Not modifiable");
    }

    @Override
    public String remove(Object key) {
        throw new UnsupportedOperationException("Not modifiable");
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        throw new UnsupportedOperationException("Not modifiable");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not modifiable");
    }

    @Override
    public Set<String> keySet() {
        return Collections.unmodifiableSet(keys);
    }

    @Override
    public Collection<String> values() {
        return keys.stream().map(this::get).collect(Collectors.toList());
    }

    @Override
    public Set<java.util.Map.Entry<String, String>> entrySet() {
        Set<Entry<String, String>> set = new HashSet<>();
        for(String s : keys) {
            set.add(new MyEntry(s, this::get));
        }
        return set;
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    public class MyEntry implements Entry<String, String> {
        private String key;
        private Function<String, String> valueSupplier;

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return valueSupplier.apply(key);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException("Not modifiable");
        }
    }

}