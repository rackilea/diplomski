public class LoginResponse {
    @SerializedName("success")
    @Expose
    private Boolean success;

    private UserObject userobject;


    public Boolean getSuccess() {
        return success;
    }

    public UserObject getUserObject() {
       return userobject;
    }
}