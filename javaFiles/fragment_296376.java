public class CompanyEmployeeTest {
    public static void main(String[] args) {
        EmployeeIdClass employeeIdClass2 = new EmployeeIdClass();
        employeeIdClass2.setName("b");
        employeeIdClass2.setRegisterNumber("2");
        EmployeeIdClass employeeIdClass3 = new EmployeeIdClass();
        employeeIdClass3.setName("c");
        employeeIdClass3.setRegisterNumber("3");

        Employee emp2 = new Employee();
        emp2.setEmail("b@");
        Employee emp3 = new Employee();
        emp3.setEmail("c@");
        emp2.setEmployeeId(employeeIdClass2);
        emp3.setEmployeeId(employeeIdClass3);

        Company company = new Company();
        Set<Employee> set = new HashSet<>();
        set.add(emp2);
        set.add(emp3);
        company.setEmployees(set);
        company.setName("first-company");
        company.setId(1234l);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(company);
        session.save(emp3);
        session.save(emp2);

        transaction.commit();
        session.close();
    }
}