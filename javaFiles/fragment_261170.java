import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private final String name;

    private final int yearOfBirth;

    public Person(@JsonProperty("name") String name, @JsonProperty("yearOfBirth") int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}