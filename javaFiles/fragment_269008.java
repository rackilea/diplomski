public class Data {

    @JsonProperty("UniqueId")
    private List<UUID> uniqueId;
    @JsonProperty("CustomerOffers")
    private Map<Integer, List<Integer>> customerOffers;
    @JsonProperty("Success")
    private Boolean success;
    @JsonProperty("ErrorMessages")
    private List<String> errorMessages;
    @JsonProperty("ErrorType")
    private String errorType;

    // getter&setters
}