static class MySecurityContext implements SecurityContext {
    private final String[] userRoles;

    public MySecurityContext(String[] roles, String user) {
        this.userRoles = roles;
    }

    @Override
    public Principal getUser() {
        return new Principal() {
            @Override
            public String getName() {
                return name;
            }
        }
    }

    public boolean isUserInRole(String role) {
        for (String userRole: userRoles) {
            if (role.equals(userRole) {
                return true;
            }
        } 
        return false;
    }

    // more methods to override
}