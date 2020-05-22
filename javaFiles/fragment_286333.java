@JsonPropertyOrder({ "inboundHeaders", "outboundHeaders"})
public class ConfigurationDataLists {
    @JsonProperty("inboundHeaders")
    private List<Header> inboundHeaders = null;

    @JsonIgnore
    @JsonProperty("outboundHeaders")
    private List<Header> outboundHeaders = null;
}