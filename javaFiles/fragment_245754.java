@Autowired
private EmployeeDAO employeeDAO;

@Test
public void whenValidEmployee_thenShouldSave()
{
    EmployeeEntity employee = new EmployeeEntity("1", "Department Name", "Role"); //id, department name and role are passing as constructor parameters
    employeeDAO.save(employee);

    List<EmployeeEntity> employees = employeeDAO.findAll();

    //Assert
    Assert.assertEquals(employee.getId(), employees.get(0).getId());
}