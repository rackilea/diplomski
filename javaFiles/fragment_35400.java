private static Map<String, List<Long>> getOutput(List<Employee> eList) {
  return eList.stream()
    // get a stream of employee / department pairs
    .flatMap(emp -> emp.getDepartmentList().stream().map(dep -> new EmployeeDepartmentPair(emp, dep))
    // filter the departments to SCIENCE
    .filter(x -> x.department.getType().equals(DepartmentType.SCIENCE))
    // group departmentIds by employee name
    .collect(Collectors.groupingBy(x -> x.employee.getName(), Collectors.mapping(x -> x.department.getDepartmentId(), Collectors.toList())))
}