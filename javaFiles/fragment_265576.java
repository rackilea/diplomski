public class Pojo {

    @JsonProperty(value = "st")
    private long stateTag;
    @JsonProperty(value = "cs")
    private long contentSize;
    @JsonProperty(value = "ct")
    private Content content;

    //getters setters
}

public class Content {

    @JsonProperty(value = "ty")
    private String type;
    @JsonProperty(value = "val")
    private String value;

}

public class App {

    public static void main(String... args) throws JsonProcessingException, IOException {

        ObjectMapper om = new ObjectMapper();

        Pojo myPojo = new Pojo(1, 10, new Content("string", "sid"));

        System.out.print(om.writerWithDefaultPrettyPrinter().writeValueAsString(myPojo));

    }