class XModel {

    private String name;

    @JsonAdapter(value = BooleanJsonDeserializer.class)
    private boolean isValid;

    // getters, setters
}