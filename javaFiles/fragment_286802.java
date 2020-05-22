@JsonCreator
public Parent(@JsonProperty("age") Integer age, @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName) {
    this.age = age;
    this.name = new Name(firstName, lastName);
}