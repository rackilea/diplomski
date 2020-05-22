@Entity
@Table(name = "employer")
public class Employer

    private Integer id;

    private String firstname;
    private String lastname;
    private String company;

    private List<Employee> employees; // one-to-many

    /* getters & setters */

}