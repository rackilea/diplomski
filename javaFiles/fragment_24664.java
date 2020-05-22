public class WebJSONObject {
    private Headers headers;

    private String origin;

    private String url;
    //setters and getters

public class Headers {

    @JsonProperty("Accept")
    private String accept;

    @JsonProperty("Accept-Encoding")
    private String acceptEncoding;

    @JsonProperty("Content-Length")
    private String contentLenght;

    @JsonProperty("Host")
    private String host;

    @JsonProperty("User-Agent")
    private String userAgent;
    //setters and getters