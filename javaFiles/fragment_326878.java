public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String name) {
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ")[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Person o) {
        return lastName.compareTo(o.getLastName());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}