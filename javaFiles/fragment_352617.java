public static class LandingPageContentItem {
    private final String id;
    private final String type;
    private final JsonNode content;

    @JsonCreator
    public LandingPageContentItem(
            @JsonProperty("id") final String id, 
            @JsonProperty("type") final String type, 
            @JsonProperty("content") final JsonNode content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    /* some logic here */
}