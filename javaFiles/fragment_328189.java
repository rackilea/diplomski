package me.eckhart;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager extends Employee {

    private List<Employee> employeeList = null;

    public ProjectManager() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Argument 'employee' is null.");
        this.employeeList.add(employee);
        return this;
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeList;
    }

    @Override
    public Employee setEmployees(List<Employee> employeeList) {
        if (employeeList == null) throw new IllegalArgumentException("Argument 'employeeList' is null.");
        this.employeeList = employeeList;
        return this;
    }

    /* Composite operations. */

    public int getWorkload(ProgrammingLanguages language) {
        int workload = 0;
        for (Employee employee : employeeList) {
            workload += employee.getWorkload(language);
        }
        return workload;
    }

    public Employee setWorkload(int workload) {
        throw new UnsupportedOperationException(Employee.OPERATION_NOT_SUPPORTED);
    }

}