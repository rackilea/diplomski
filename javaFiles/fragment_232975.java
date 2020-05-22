@JsonIgnoreProperties(ignoreUnknown = true)
public class MyClass {
    @JsonProperty("value-one")
    private String valueOne;
    @JsonProperty("value-two")
    private String valueTwo;
    @JsonProperty("value-three")
    private String valueThree;

    public MyClass(
        @JsonProperty(value = "value-one", required = true) String valueOne,
        @JsonProperty(value = "value-two", required = true) String valueTwo,
        @JsonProperty(value = "value-three", required = false) String valueThree) {
        ..
    }
}