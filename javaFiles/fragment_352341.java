public static void main(String[] args) {
    Test t = new Test();

    // Dummy Values (with two different employees based on `id` = "001" & "002")
    List<Emp> employeeList = new ArrayList<>();
    employeeList.add(new Emp("001", "ABC", "DEF", t.getEmployeeRegionList("USA")));
    employeeList.add(new Emp("001", "ABC", "DEF", t.getEmployeeRegionList("UK")));
    employeeList.add(new Emp("001", "ABC", "DEF", t.getEmployeeRegionList("INDIA")));
    employeeList.add(new Emp("001", "ABC", "DEF", t.getEmployeeRegionList("CHINA")));
    employeeList.add(new Emp("002", "ABC", "DEF", t.getEmployeeRegionList("CHINA", "RUSSIA")));
    employeeList.add(new Emp("002", "ABC", "DEF", t.getEmployeeRegionList("USA")));

    System.out.println(t.getEmployeesWithMergedEmpRoles(employeeList));
}

private List<Emp> getEmployeesWithMergedEmpRoles(List<Emp> employeeList) {
    return new ArrayList<>(employeeList.stream().collect(Collectors.toMap(emp -> Arrays.asList(emp.getId(), emp.getFirstName(), emp.getLastName()), 
            Function.identity(), (oldValue, newValue) -> {
        oldValue.getEmpRegionList().addAll(newValue.getEmpRegionList());
        return oldValue;
    })).values());
}

private List<EmpRegion> getEmployeeRegionList(String... regions) {
    List<EmpRegion> empRegionList = new ArrayList<>();
    for (String region : regions) {
        empRegionList.add(new EmpRegion("RL-" + region, region));
    }
    return empRegionList;
}