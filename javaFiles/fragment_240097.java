class User {
    @JsonProperty
    String id;
    @JsonProperty
    String title;
    @JsonProperty
    String email;
    @JsonProperty
    String department;
    @JsonProperty
    String name;
    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + "]";
    }

}