public static class EmployeeStatistics {
  private final int average;
  private final int efficiency;
  // constructor, getters and setters
}

Supplier<EmployeeStatistics> statistics = Suppliers.memoize(
    new Supplier<EmployeeStatistics>() {
  @Override
  public EmployeeStatistics get() {
    List<Employee> employees = new Service().getAllEmployees();
    return new EmployeeStatistics(
        calculateEmployeeAvg(employees),
        calculateEmployeeEff(employees));
  }});