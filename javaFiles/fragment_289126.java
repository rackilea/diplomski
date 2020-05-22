@Entity
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @OneToOne(mappedBy = "employee")
    private Manager manager;