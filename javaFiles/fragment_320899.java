public class TestUserHelper {

    private String USER_ROLE_EMPLOYEE, USER_ROLE_MANAGER;

    @Before
    public void setUp() throws Exception {
        USER_ROLE_EMPLOYEE = "Service Desk";
        USER_ROLE_MANAGER = "Store Manager";
    }

    @Test
    public void testIsUserRoleValidEmployee() {
        Assert.assertTrue(UserValidator.validateSupervisor(USER_ROLE_EMPLOYEE));
    }

    @Test
    public void testIsUserRoleValidSupervisor() {
        Assert.assertTrue(UserValidator.validateSupervisor(USER_ROLE_MANAGER));
    }
}