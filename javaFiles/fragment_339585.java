public class Department {

@Id
private Long id;
@Column(name = "dept_name")
private String deptName;
@Column(name = "dept_description")
private String deptDescription;
@ManyToOne
private Company company;

/*Getters, Setters, toString*/
}