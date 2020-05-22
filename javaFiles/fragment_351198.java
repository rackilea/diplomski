public class Product {

    @JsonProperty("name")
    public String name;
    @JsonDeserialize(using = FlexibleFloatDeserializer.class)
    @JsonProperty("latitude")
    public float latitude;
    @JsonDeserialize(using = FlexibleFloatDeserializer.class)
    @JsonProperty("longitude")
    public float longitude;

}