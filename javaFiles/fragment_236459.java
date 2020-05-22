public class Person {

    private final String type;

    private final String name;

    @JsonCreator
    public Person(@JsonProperty("@type") String type, @JsonProperty("name") String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}