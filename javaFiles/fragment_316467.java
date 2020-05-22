@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName="product")
@JsonPropertyOrder({ "sku", "image", "brand", "sizeCM", "colors", "genders",
        "occasions", "categories" })
public class Product {

    @JsonProperty("sku")
    @JacksonXmlProperty(localName="sku")
    private String sku;

    @JsonProperty("image")
    @JacksonXmlProperty(localName="image")
    private String image;

    @JsonProperty("brand")
    @JacksonXmlProperty(localName="brand")
    private String brand;

    @JsonProperty("sizeCM")
    @JacksonXmlProperty(localName="sizeCM")
    private String sizeCM;

    @JsonProperty("colors")
    @JacksonXmlProperty(localName = "colors")
    @XmlElement(name="colors")
    private Colors colors;