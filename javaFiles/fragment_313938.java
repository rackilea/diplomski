@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = StringValue.class, name = "string"),
    @JsonSubTypes.Type(value = DateValue.class, name = "date"),
    @JsonSubTypes.Type(value = MapValue.class, name = "map")
})
abstract class HasValue<T> {

    protected T value;

    public HasValue() {
        this(null);
    }

    public HasValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
            "value=" + value +
            "}";
    }
}

class StringValue extends HasValue<String> {

    public StringValue() {
        this(null);
    }

    public StringValue(String value) {
        super(value);
    }
}

class DateValue extends HasValue<String> {

    public DateValue(String value) {
        super(value);
    }

    public DateValue() {
        this(null);
    }
}

class MapValue extends HasValue<Map<String, HasValue>> {

    public MapValue(Map<String, HasValue> value) {
        super(value);
    }

    public MapValue() {
        this(new LinkedHashMap<>());
    }

    public void put(String key, HasValue hasValue) {
        this.value.put(key, hasValue);
    }
}