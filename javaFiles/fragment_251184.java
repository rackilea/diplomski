@Test
public void createEmployee() {
    Employee emp = new Employee();
    emp.setName("Test2");
    emp.setSalary(1000);
    emp.setId(101);
    tx.begin();
    em.merge(emp);
    tx.commit();
}