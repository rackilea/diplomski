@JsonInclude(JsonInclude.Include.NON_NULL)  // This will exclude null JSON attributes.
@JsonIgnoreProperties(ignoreUnknown = true) // This will exclude any unknown(not available in the class) attribute in the JSON string.
public class Car {

    @JsonProperty("image_url") // No matter if you didn't use this annotation. Jackson will automatically bind the variable name.
    private String image_url;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("engine")
    private String engine;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("hp")
    private Integer hp;

    @JsonProperty("mileage")
    private Integer mileage;

    @JsonProperty("color")
    private String color;

    // Omitted the rest.
}