public class ApiResponse {

    @SerializedName("$id")
    public String id;
    @SerializedName("Chapters")
    public List<Chapter> chapters = null;
    @SerializedName("Subjects")
    public List<Subject> subjects = null;
    @SerializedName("Standards")
    public List<Standard> standards = null;

    //getter-setter
}