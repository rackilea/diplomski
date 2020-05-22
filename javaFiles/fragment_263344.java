private List<Employee> employees = new ArrayList<Employee>();

public List<Employee> getEmployees() {
    if(employees.isEmpty()){
       employees.addAll(empList());
    }
    return employees;
}