@Entity
public class Organization {
   @OneToMany(cascade=ALL)
   @JoinTable(
        name="ACTIVE_EMPLOYEES",
        joinColumns = @JoinColumn( name="ORGANIZATION_ID"),
        inverseJoinColumns = @JoinColumn( name="EMPLOYEE_ID")
   )
   List<Employee> employees;         
   ...            
}