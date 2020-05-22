public class Request {

    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String payload;

    private String signature;

    // Getters and setters ommitted
}