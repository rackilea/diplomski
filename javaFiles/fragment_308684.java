class Response {

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "name", visible = true)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = GetSettingsResponseParams.class, name = "settings_response"),
            @JsonSubTypes.Type(value = Params.class, name = "simple_response")
    })
    private Params params;
    private String name;

    // getters, settets, toString, etc.
}