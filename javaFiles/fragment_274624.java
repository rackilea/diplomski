interface EmployeeDAO {

    List<Employee> findAll();
    List<Employee> findById();
    List<Employee> findByName();
    boolean insertEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);

}