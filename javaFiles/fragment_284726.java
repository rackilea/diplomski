@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"result",
"error"
})
public class OptionChain {

@JsonProperty("result")
private List<Result> result = null;
@JsonProperty("error")
private Object error;
// getter and setters

}