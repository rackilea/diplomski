private static Map<String, Long> getOutput(List<Employee> eList) {
  return  eList.stream()
    .flatMap(emp -> emp.getDepartmentList().stream().map(dep -> new EmployeeDepartmentPair(emp, dep))
    .filter(x -> x.department.getType().equals(DepartmentType.SCIENCE))
    .collect(Collectors.toMap(x -> x.employee.getName(), x -> x.department.getDepartmentId()));
}

private static class EmployeeDepartmentPair {
  public final Employee employee;
  public final Department department;

  public EmployeeDepartmentPair(Employee emp, Department d) {
    this.employee = emp;
    this.department = d;
  }
}