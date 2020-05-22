public class TestUserHelper {

    private static final String USER_ROLE_EMPLOYEE = "Service Desk";
    private static final String USER_ROLE_MANAGER = "Store Manager";

    @Test
    public void testIsUserRoleValidEmployee() {
        Assert.assertTrue(UserValidator.validateSupervisor(USER_ROLE_EMPLOYEE));
    }

    @Test
    public void testIsUserRoleValidSupervisor() {
        Assert.assertTrue(UserValidator.validateSupervisor(USER_ROLE_MANAGER));
    }
}