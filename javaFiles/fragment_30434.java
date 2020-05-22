@Entity
 @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="employee_id")
 public class Employee {
     @JoinTable(name = "company_employee", joinColumns = @JoinColumn(name = "employee_id") , inverseJoinColumns = @JoinColumn(name = "company_id") )
     @ManyToMany(fetch = FetchType.EAGER)
     private Set<Company> companies;
 }