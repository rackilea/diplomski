public class AuthorizationInterceptor extends HandlerInterceptorAdapter{

    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    // The rest of your code
}