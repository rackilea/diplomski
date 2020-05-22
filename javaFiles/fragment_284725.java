@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"optionChain"
})
public class MyPOJO {

@JsonProperty("optionChain")
private OptionChain optionChain;
// getters and setters 
}