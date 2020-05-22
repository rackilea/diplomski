@Entity
public class Employee 
{
  @Id
  @GeneratedValue
  private Integer id;
  @Version
  private long version;
  private String name;
}