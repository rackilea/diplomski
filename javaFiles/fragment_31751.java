public class Employee {
  @OneToMany(mappedBy = "employee")
  private Set<Emp_Contacts> contacts;
}

public class Emp_Contacts {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emp_id", nullable = false)
  private Employee employee;
}