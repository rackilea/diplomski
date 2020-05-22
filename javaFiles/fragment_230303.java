import java.util.Comparator;
public class EmployeesComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    return o1.age - o2.age;
  }
}