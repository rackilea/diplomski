@Entity
public class Employee {

    @Id 
    @GeneratedValue 
    private Long id;

    private String firstName, lastName, description;

    private Employee() {}

    public Employee(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    // Autogenerate here getters, setters and toString()
}