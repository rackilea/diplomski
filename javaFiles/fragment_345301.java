@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    // Injecting your repository
    @Autoware
    private EmployeeRepository repo;

    @Test
    public void dbTest() {

        // Create two employees
        Employee gandalf = new Employee("Gandalf", "Grey", "Wizard");
        Employee frodo = new Employee("Frodo", "Baggins", "Hobbit");

        // Save them to DB
        repo.save(Arrays.asList(gandalf, frodo));

        // Read them from DB
        List<Employee> employees = repo.findAll();

        // Print them
        employees.forEach(System.out::println);
    }
}