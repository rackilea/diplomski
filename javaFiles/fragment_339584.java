public class Company {

@Id
private Long id;
@Column(name = "company_name")
private String companyName;
@Column(name = "company_registration_number")
private int companyRegistrationNumber;
@Column(name = "company_address")
private String companyAddress;
@OneToMany
private Set<Department> departments;

/*  Getters, Setters, toString */
}