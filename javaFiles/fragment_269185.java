public interface EventMixIn {

    @JsonProperty("representation")
    @JsonSerialize(using = CustomSerializer.class)
    Object getRepresentation();
}