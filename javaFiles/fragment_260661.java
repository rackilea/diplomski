Employee employee = getEmployeeByName("Someniceemployeename");
if (employee != null)
{
    employee.setEmployeeEmail("awesomeness@stackoverflow.com");
    edit(employee);
}