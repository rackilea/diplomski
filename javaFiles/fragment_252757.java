public class Action implements Serializable {

    @Id
    private String id;
    private String name;
    private String applicationId;
    private String timeStamp;
    private String username;
    private Map<String, String> options;
    //Getters and Setters
}