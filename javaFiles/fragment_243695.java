public class MongoObject
{
    @JsonProperty("_id")
    @org.jongo.marshall.jackson.oid.ObjectId
    private String _id;

    @JsonProperty("userID")
    private String userID;
    @JsonProperty("appID")
    private String appID;
    @JsonProperty("message")
    private String message;
    @JsonProperty("session")
    private String session;

    public MongoObject() {}

//... insert constructors, hashCode, equals and toString just for testing...
}