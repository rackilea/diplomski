@Entity
public class Employee {

    @Id
    @GeneratedValue(generator = "UniqueIdGenerator")
    @GenericGenerator(name = "UniqueIdGenerator", strategy = "com.CourierTransImpl", 
    parameters = { @Parameter(name = "appendString", value = "Emp") })
    private String id;
    private String name;
    @Transient
    private String empType;

   // Getters & Setters
}