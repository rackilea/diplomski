public class APIRequest {
    @JsonProperty("code")
    public String code;

    @JsonProperty("error")
    public APIError error;

    @JsonProperty("results")
    Map<String, String> results;
}