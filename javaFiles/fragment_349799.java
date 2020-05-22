class ParseDeserializer extends StdDeserializer<LocalDateTime> {
    public ParseDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return LocalDateTime.parse(p.getValueAsString()); // or overloaded with an appropriate format
    }
}
...
@JsonSerialize(using = ToStringSerializer.class)
@JsonDeserialize(using = ParseDeserializer.class)
private LocalDateTime initiationDate;