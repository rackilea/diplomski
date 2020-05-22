@Builder
@Getter
@Setter
@Value
@RequiredArgsConstructor
@JsonDeserialize()
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleInfo {
      private String country;
      private String saleability; //This
      private boolean isEbook; //THis
     // created only if required
      private String buyLink;

    //TODO i want to have a conditional creation of this two objects below.
      ListPrice listPrice;
      RetailPrice retailPrice;

    @JsonCreator
    public SaleInfo(
        @JsonProperty("country") String country;
        @JsonProperty("saleability") String saleability;
        @JsonProperty("isEbook") boolean isEbook;
        @JsonProperty(value = "buyLink", required = false) String buyLink;
        @JsonProperty(value = "listPrice", required = false) ListPrice listPrice;
        @JsonProperty(value = "retailPrice", required = false) RetailPrice retailPrice;
    ) {
     this.country = country;
     this.saleability = saleability;
     this.isEbook = isEbook;
     this.buyLink = buyLink;
     this.listPrice = listPrice;
     this.retailPrice = country;

    }


    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }