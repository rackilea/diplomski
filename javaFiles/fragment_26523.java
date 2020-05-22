public class Configuration implements Serializable {

    @Override
    public String toString() {
        return "Configuration [port=" + port + ", URL=" + URL + ", repository=" + repository + "]";
    }

    private static final long serialVersionUID = 8642243843212797330L;

    private Integer port;

    private String URL;



    @SerializedName("Repository")
    private Repository repository;

}