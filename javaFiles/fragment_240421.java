public class ExampleObject {
    public static final String API_KEY = "get_response";
    private static final String OFFSETS = "offsets";

    @SerializedName(OFFSETS)
    private List<Integer> mOffsets;



    public ExampleObject() {
        super();
    }

    public String getAPIKey() {
        return API_KEY;
    }

    public List<Integer> getOffsets() {
        return mOffsets;
    }
}