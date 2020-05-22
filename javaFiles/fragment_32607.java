public class MapWrapper {

    @JsonSerialize(using = CustomSerializer.class)
    @JsonDeserialize(using = CustomDeserializer.class)
    private Map<Object1, Object2> map = new HashMap<>();

    private Map<String, String> someMap = new HashMap<>();

    // default constructor, getters, setters
}