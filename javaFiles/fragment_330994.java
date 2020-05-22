class TopLevelObject {
    public String type;
    public String name;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
            include= JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = FooParams.class, name = "foo"),
            @JsonSubTypes.Type(value = BarParams.class, name = "bar")})
    public AbstractParams params;

}