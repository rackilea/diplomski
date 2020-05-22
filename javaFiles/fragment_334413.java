public class Gender implements Serializable {

    @SerializedName("value")
    public String value;

    @SerializedName("confidence")
    public int confidence;

}