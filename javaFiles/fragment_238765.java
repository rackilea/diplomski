public class BaseMessage<T> {

    @JsonProperty("val1")
    String val1;
    @JsonProperty("val2")
    T val2;
}