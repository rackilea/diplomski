public class LogInUser {

    @JsonCreator
    public LogInUser(@JsonProperty(value = "identifier", required = true) String identifier, @JsonProperty(value = "password", required = true) String password) {
    this.identifier = identifier;
    this.password = password;
    }

    public String identifier, password;
    public LogInUser() {}

}