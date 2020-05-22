class PL {
    @JsonProperty("StatusCode")
    private Long statusCode;
    @JsonProperty("ExecutionTime")
    private String executionTime;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("ResponseData")
    private List<ResponseData> responseDatas;

    public PL(){
    }

    // getters/Setters  

}


class ResponseData {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("SiteId")
    private String siteId;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("X")
    private String x;
    @JsonProperty("Y")
    private String y;

    public ResponseData(){
    }

    // getters/Setters  

}