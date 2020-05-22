List<Employee> employees = employeeService.list();

for (Employee employee : employees) {
    String location = request.getParameter("location_" + employee.getId());
    // ...
}