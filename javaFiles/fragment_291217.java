public enum Thing {
  EMPLOYEE(Employee.class),
  BOARDING(Boarding.class),
  ADDRESS(Address.class),
  SALARY(Salary.class);

  private final Class clazz;
  Thing(Class clazz) {
    this.clazz = clazz;
  }

  public Class getClassOfThing() {
    return clazz;
  }
}