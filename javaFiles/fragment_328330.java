@Entity
@Table(name="EMPLOYEE")
public class Employee {


@Id
@GeneratedValue
@Column(name="employee_id")
private Long employeeId;

@Column(name="firstname")
private String firstname;

@Column(name="lastname")
private String lastname;

@ManyToOne
@JoinColumn(name="department_id")
private Department department;
// Getter and Setter methods