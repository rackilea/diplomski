@Entity
@Table(name="DEPARTMENT")
public class Department {


@Id
@GeneratedValue
@Column(name="department_id")
private Long departmentId;

@Column(name="department_name")
private String departmentName;

@OneToMany(mappedBy="department")
private Set<Employee> employees;

// Getter and Setter methods