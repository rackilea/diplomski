public class EmployeeController {
  . . .
  public View listEmployees() {
    List<Employee> employees = storage.getAllEmployees();
    return new EmployeeListing(employees); 
  }
}