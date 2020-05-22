@Entity
@Table(name = "employee")
public class Employee {

    private Integer id;

    @Transient // means "not a DB field"
    private Integer remove; // boolean flag

    private String firstname;
    private String lastname;

    private Employer employer; // many-to-one

    /* getters & setters */

}