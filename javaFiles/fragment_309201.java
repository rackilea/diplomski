@IgnoreExtraProperties
public class FCM_Device_Tokens {

    @SerializedName("token")
    private String token;

    public FCM_Device_Tokens() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}