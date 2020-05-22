public class TestDatabaseManager extends AndroidTestCase {

    HrSuiteDatabaseManager dbm;

    public void setUp() throws Exception {
        super.setUp();

        RenamingDelegatingContext rdcontext = new RenamingDelegatingContext(getContext(), "test_");
        dbm = new HrSuiteDatabaseManager(rdcontext);
        dbm.registerTableAccess(new EmployeeAccess());
    }

    public void testInsertion() {
        EmployeeAccess ea = dbm.getEmployeeAccess();
        ea.insert(createEmployee(0));

        List<Employee> emps = ea.getAll();
        assertEquals(1, emps.size());

        assertEmployee(emps.get(0), 0);
    }
}