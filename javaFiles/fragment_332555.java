@Service
public class EmployeeService {

    @Autowired
    private SalaryService salaryService;

    @Transactional
    public void computeEmployeeSalary(Integer employeeId){
        Employee employee = entityManager.find(Employee.class , employeeId);
        salaryService.computeSalary(employee, .... ,.....);
    }

}