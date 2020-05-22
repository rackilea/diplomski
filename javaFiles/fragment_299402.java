// PascalCaseStrategy is to resolve Id and Subject properties
@JsonNaming(PascalCaseStrategy.class)
public class Value {

    @JsonProperty("@odata.id")
    public String odataId;

    @JsonProperty("@odata.etag")
    public String odataEtag;

    public String id;
    public String subject;
}