@PersistenceCapable
public class Team {
  @Persistent(mappedBy = "team")
  private List<Employee> employees;
}

@PersistenceCapable
public class Employee {
  @PrimaryKey
  private String user;

  @Persistent
  private Team team;
}