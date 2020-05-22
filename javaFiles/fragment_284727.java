@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"expirationDate",
"hasMiniOptions",
"calls",
"puts"
})
public class Option {

@JsonProperty("expirationDate")
private Integer expirationDate;
@JsonProperty("hasMiniOptions")
private Boolean hasMiniOptions;
@JsonProperty("calls")
private List<Call> calls = null;
@JsonProperty("puts")
private List<Put> puts = null;