@Override
public Employee load(long id) {
    ...
    long departmentId = ....
    Department department = departmentDAO.load(departmentId);
    employee.department = department;
    return employee;
}