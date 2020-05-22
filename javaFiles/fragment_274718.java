public class CustomRequest {

    @JSonProperty(value = "total");
    private Integer total;

    @JsonProperty(value = "data")
    private List<CustomObject> data;

    // getters/setters

}


public class CustomObject {

    @JsonProperty(value = "descriptor")
    private String descriptor;

    @JsonProperty(value = "multiInstance")
    private Boolean multiInstance;

    // getters/setters
}