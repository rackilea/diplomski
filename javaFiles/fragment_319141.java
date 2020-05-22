public class Port {
    @JsonProperty("IP")
    private String ip;

    @JsonProperty("PrivatePort")
    private int privatePort;

    @JsonProperty("PublicPort")
    private int publicPort;

    @JsonProperty("Type")
    private String type;

    // Getters and setters
}