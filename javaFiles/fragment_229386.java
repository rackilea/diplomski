package forum11059499;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EmployeeAdapter extends XmlAdapter<Employee, Employee>{

    @Override
    public Employee marshal(Employee employee) throws Exception {
        Employee partialEmployee = new Employee();
        partialEmployee.setEmployeeId(employee.getEmployeeId());
        partialEmployee.setEmployeeName(employee.getEmployeeName());
        return partialEmployee;
    }

    @Override
    public Employee unmarshal(Employee employee) throws Exception {
        return employee;
    }

}