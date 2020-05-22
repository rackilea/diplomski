private static String json = "[{\"a\":\"a\",\"b\":1},{\"a\":\"b\",\"b\":2}]";
@Data
public static class MyObject {
    @JsonValue   // used during serialization
    private List<BaseType> rootList;
    @JsonCreator //used during deserialization
    public MyObject(List<BaseType> items ) {
        this.rootList = items;
    }
}

@Data
public static class BaseType {
    @JsonProperty
    private String a;
    @JsonProperty
    private int b;
}

public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    MyObject value = mapper.readValue(json, MyObject.class);
    System.out.println(value);
    System.out.println(mapper.writeValueAsString(value));
}