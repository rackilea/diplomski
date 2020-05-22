public class MyMessage {

    @JsonProperty("@odata.context")
    public String context;

    @JsonProperty("value")
    public Value[] values;
}