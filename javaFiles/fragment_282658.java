public class EmpMB{
...
private List<Department> departmentList;
private Employee employee;

public List getDepartmentList(){
    return departmentList;
}

public void onEmployeeSelect(){
    departmentList = someService.getDepartmentsForEmployee(employee);
}
...
}