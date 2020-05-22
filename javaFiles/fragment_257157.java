public class FacetMixIn
{
    @JsonProperty("Name")
    public String name;

    @JsonProperty("Value")
    public String value;
}

objectMapper.getDeserializationConfig().addMixInAnnotations(Facet.class, FacetMixIn.class);