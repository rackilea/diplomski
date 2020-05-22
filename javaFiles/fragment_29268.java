@RestController
public class EmployeesController {

    @Autowired
    private LdapService service;

    @RequestMapping(value = "/employees/{empId}")
    public Employee getEmployee(@PathVariable("empId") Long empId) {
        Employee emp = ldapService.getEmployee(empId);
        return emp;
    }
}