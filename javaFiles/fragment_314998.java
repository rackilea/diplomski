public class Artist {
    private String name;
    ...
    @JsonValue
    public String getName() { return name; }
}