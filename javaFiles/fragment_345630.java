@Entity
@Table(name = "EMPLOYEE")
public class Employee
{
  @Id//<-need to specify a generator here 
  @Column(name = "ID", length = 50)
  private String id;

  @Column(name = "ID", length = 50)
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  //define FK column in Address table
  @JoinColumn(joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), 
      foreignKey = @ForeignKey(name = "EMPLOYEE_Address_FK"))
  private List<Address> address;
}