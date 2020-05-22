application.properties

my.security.admin-roles-list=RoleA,RoleB,RoleC

@Component("securityConfiguration")
public class SecurityConfiguration {

    @Value("#{'${my.security.admin-roles-list}'.split(',')}") 
    private List<String> adminRoles;

    public List<String> getAdminRoles() {
        return adminRoles;
    }
}