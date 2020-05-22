@JsonIgnoreProperties(ignoreUnknown = true)
public class Foo {

    @JsonProperty("submitted_datetime")
    private String submittedDateTime;

    private Integer value;

    // Getters and setters
}