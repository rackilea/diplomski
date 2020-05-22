@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="company_id")
public class Company {
     @JoinTable(name = "company_employee", joinColumns = @JoinColumn(name = "company_id") , inverseJoinColumns = @JoinColumn(name = "employee_id") )
     @ManyToMany(fetch = FetchType.LAZY)
     private Set<Employee> employees;
}