public static final class DirectEnumerableDeserializer<E extends Enum<E> & IEnumerable<E>> extends
        StdScalarDeserializer<E> {
    private final Class<E> enumerableClass;
    private final ImmutableList<E> values;
    private final ImmutableMap<String, E> names;

    public DirectEnumerableDeserializer(Class<E> enumerableClass) {
        super(enumerableClass);
        this.enumerableClass = enumerableClass;
        this.values = ImmutableList.copyOf(enumerableClass.getEnumConstants());
        ImmutableMap.Builder<String, E> names = ImmutableMap.builder();
        for (E value : values) {
            names.put(value.name(), value);
        }
        this.names = names.build();
    }

    @Override
    public E deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String key = p.getText();
        E value = names.get(key);
        if (value == null) {
            value = findByLocalisedName(key);
            if (value == null) throw ctxt.weirdStringException(key, enumerableClass, "Unrecognised name");
        }
        return value;
    }

    private E findByLocalisedName(String key) {
        for (E value : values) {
            if (value.getName().equals(key)) return value;
        }
        return null;
    }
}