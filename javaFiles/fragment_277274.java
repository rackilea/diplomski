@MappedSuperclass
public abstract class BasicInfo implements java.io.Serializable {       
    @Column(name = "name")
    protected String name = EMPTY_STRING;
    @Column(name = "age")
    protected Integer age = null; 
}

//Employee class
@Entity
@Table (name ="EmployeeTable")
public class Employee extends BasicInfo{
    @Id
    @Column(name="EmployeeID")
    private String Id;
}

//Manager class
@Entity
@Table (name ="ManagerTable")
public class Manager extends BasicManagerInfo{
    @Id
    @Column(name="ManagerID")
    private String Id;

}