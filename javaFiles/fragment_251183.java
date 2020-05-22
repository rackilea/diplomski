@Test
public void createEmployee() {
    Employee emp = new Employee();
    emp.setName("Test");
    emp.setSalary(1000);
    tx.begin();
    em.merge(emp);
    tx.commit();
}