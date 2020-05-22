private Integer salary;
private boolean valid;

@Test 
public void testValid() {
  if (valid) {
    Employee e = new Employee();      
    e.setSalary(salary);
    assertEqual(salary, e.getSalary());
  }
}

@Test(expected=EmployeeInvalidSalaryException.class) 
public void testInvalid() {
  if (!valid) {
    Employee e = new Employee();      
    e.setSalary(salary);
  }else {
    throw new EmployeeInvalidSalaryException();
  }
}