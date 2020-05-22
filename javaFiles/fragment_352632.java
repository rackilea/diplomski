public class ReverseEnumMap<V extends Enum<V> & EnumConverter> {
    private Map<Byte, V> map = new HashMap<Byte, V>();
    public ReverseEnumMap(Class<V> valueType) {
        for (V v : valueType.getEnumConstants()) {
            map.put(v.convert(), v);
        }
    }

    public V get(byte num) {
        return map.get(num);
    }
}