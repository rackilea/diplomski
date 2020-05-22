@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Person {
    private final String email;
    private final String name;

    public Person(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    // Will use special conversion before serializing
    @JsonSerialize(converter = EmailConverter.class)
    public String getEmail() {
        return email;
    }

    // Will simply use default serialization
    public String getName() {
        return name;
    }
}