public class CaseInsensitiveStrLookup<V> extends StrLookup<V> {

private final Map<String, V> map;

CaseInsensitiveStrLookup(final Map<String, V> map) {
    this.map = map;
}

@Override
public String lookup(final String key) {
    String lowercaseKey = key.toLowerCase(); //lowercase the key you're looking for
    if (map == null) {
        return null;
    }
    final Object obj = map.get(lowercaseKey);
    if (obj == null) {
        return null;
    }
    return obj.toString();
}
}