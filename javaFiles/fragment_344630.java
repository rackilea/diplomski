public class user {
    private String username;
    private String password;

    @JsonIgnore
    private String getPassword() {
        return password;
    }

    @JsonProperty
    private void setPassword(String password) {
        this.password = password;
    }
}