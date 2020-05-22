public class MyCheckedMap<K, V>
extends SomeMapImplementation<K, V>
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Class<K> keyType;
    private final Class<V> valueType;

    public MyCheckedMap(Class<K> keyType, Class<V> valueType) {
        this.keyType = Objects.requireNonNull(keyType);
        this.valueType = Objects.requireNonNull(valueType);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> MyCheckedMap<K, V> cast(
            Object obj, Class<K> keyType, Class<V> valueType) {
        if (!(obj instanceof MyCheckedMap<?, ?>))
            throw new ClassCastException(obj.getClass().toString());

        MyCheckedMap<?, ?> map = (MyCheckedMap<?, ?>) obj;
        validate(keyType, map.keyType);
        validate(valueType, map.valueType);

        return (MyCheckedMap<K, V>) obj;
    }

    private static void validate(Class<?> lhs, Class<?> rhs) {
        if (lhs == rhs)
            return;
        throw new ClassCastException(String.format("%s != %s", lhs, rhs));
    }
}