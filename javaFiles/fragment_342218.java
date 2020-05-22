public class Wrapper {

    private String type;

    @JsonTypeInfo(use = Id.NAME, property = "type", include = As.EXTERNAL_PROPERTY)
    @JsonSubTypes(value = { 
        @JsonSubTypes.Type(value = Foo.class, name = "foo"),
        @JsonSubTypes.Type(value = Bar.class, name = "bar") 
    })
    private AbstractData data;

    // Getters and setters
}