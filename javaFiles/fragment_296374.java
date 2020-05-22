@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @Column(name = "employeeId", nullable = false, length = 50)
    private EmployeeIdClass employeeId;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeIdClass getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeIdClass employeeId) {
        this.employeeId = employeeId;
    }
}