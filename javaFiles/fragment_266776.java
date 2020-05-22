class Views {
    static class PublicView { }
    static class StreamA extends PublicView { }
    static class OtherWay extends PublicView { }
}

public class Value {
    @JsonView(Views.PublicView.class) public int value;
    @JsonView(Views.OtherWay.class) public int value2;
    @JsonView(Views.StreamA.class) public int value3;
}


String json = new ObjectMapper()
              .writerWithView(Views.OtherWay.class)
              .writeValueAsString(valueInstance);