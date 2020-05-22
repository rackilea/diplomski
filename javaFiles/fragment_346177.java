// 1
@JsonFormat(shape = JsonFormat.Shape.Object)
public enum CarStatus {
    NEW("Right off the lot"),
    USED("Has had several owners"),
    ANTIQUE("Over 25 years old");

    public String description;

    public CarStatus(String description) {
        this.description = description;
    }

    // 2
    @JsonCreator
    public static CarStatus fromNode(JsonNode node) {
        if (!node.has("name"))
            return null;

        String name = node.get("name").asText();

        return CarStatus.valueOf(name);
    }

    // 3
    @JsonProperty
    public String getName() {
        return name();
    }
}