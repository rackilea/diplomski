@Entity
public class Employee {
    @Id
    private int id; //determines persistent identity
    public Employee(int id) { this.id = id; }
}