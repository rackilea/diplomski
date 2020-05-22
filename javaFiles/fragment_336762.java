public enum LookupKey { FOO, BAR }

public final class Repository {
    private final Map<LookupKey, Object> data = new HashMap<>();

    public void put(LookupKey key, Object value) {
        data.put(key, value);
    }

    public Object get(LookupKey key) {
        return data.get(key);
    }
}