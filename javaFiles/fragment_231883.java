public class MyDataObject {
    private final Map<String, TypeA> data;

    @JsonCreator
    public MyDataObject(@JsonProperty("data") final Map<String, TypeA> data) {
        this.data = data;
    }

    public Map<String, TypeA> getData() {
        return data;
    }
}

public class TypeA {
    private final String id;
    private final String name;

    @JsonCreator
    public TypeA(@JsonProperty("id") final String id, 
                 @JsonProperty("name") String name) {

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}