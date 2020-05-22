public class Student {
    @JsonProperty("profile_root")
    private String profileRoot;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("studentkey")
    private String studentKey;
    // GETTERS and SETTERS

    @Override
    public String toString() {
        return "Student{" + "profileRoot=" + profileRoot + ", nickname=" 
            + nickname + ", email=" + email + ", studentKey=" + studentKey + '}';
    }
}