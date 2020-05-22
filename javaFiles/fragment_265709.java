import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person {

    private String name;

    private Long ageInSeconds;

    public Person(String name, Long ageInSeconds) {
        this.name = name;
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(13, 31) // pick two hard coded odd numbers, preferably different for each class
                .append(name)
                .append(ageInSeconds)
                .build();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Person rhs = (Person) obj;
        return new EqualsBuilder()
                // .appendSuper(super.equals(obj)) not needed here, but would be used if example Person extended another object
                .append(name, rhs.name)
                .append(ageInSeconds, rhs.ageInSeconds)
                .isEquals();
    }
}