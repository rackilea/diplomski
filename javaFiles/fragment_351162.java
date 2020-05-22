//lower cases since it affects the json output not the class field names
@JsonPropertyOrder({ "topic", "subscriptionReference", "utcTime", "messages" })
public class CreateEventWrapper {

    private String Topic;
    private String SubscriptionReference;
    private Date UtcTime;
    private List<Message> Messages;
    ...
}