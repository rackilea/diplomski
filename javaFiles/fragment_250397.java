@JsonCreator
public Employee(
        @JsonProperty(value = "username") String username,
        @JsonProperty(value = "firstName") String firstName,
        @JsonProperty(value = "lastName") String lastName,
        @JsonProperty(value = "password") String password,
        @JsonProperty(value = "email") String email,
        @JsonProperty(value = "phoneNumber") String phoneNumber
) {
    super(username, firstName, lastName, password, email, phoneNumber);
}