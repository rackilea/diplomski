public static List<Employee> getEmployeeListFromPersonList(List<Person> list) {
    return list.stream()                            // 1.Iterate
               .filter(Employee.class::isInstance)  // 2.Check type
               .map(Employee.class::cast)           // 3.Cast
               .collect(Collectors.toList());       // 3.Keep them
}