// The author class (a bit cleaned up)
public class Author {
    private final String givenName;
    private final String surname;

    @JsonCreator
    public Author(
            @JsonProperty("given-name") final String givenName,
            @JsonProperty("surname") final String surname) {

        this.givenName = givenName;
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }
}