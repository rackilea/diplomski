@JsonPropertyOrder({ "inboundHeaders", "outboundHeaders"})
public class ConfigurationDataString {
    @JsonProperty("inboundHeaders")
    private String inboundHeader = null;

    @JsonProperty("outboundHeaders")
    private String outboundHeader = null;
}