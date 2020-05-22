@SuppressWarnings("unused")
@JsonCreator
private Person(@JsonProperty(Person.LAST_NAME) String lastName, @JsonProperty(Person.FIRST_NAME) String firstName, @JsonProperty(Person.COUNTRY) String country) {
    this.lastName = lastName.trim();
    this.firstName = firstName.trim();
    this.country = country.trim();
}