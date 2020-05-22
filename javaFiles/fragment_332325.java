import org.sonatype.nexus.security.role.RoleIdentifier;
import org.sonatype.nexus.security.user.User;
import org.sonatype.nexus.security.user.UserManager;

String userId = 'NA10009';
String newRoleId = 'dot-maven'
String realm = 'LDAP'
String role_realm = 'default'

User user = security.securitySystem.getUser(userId, realm)
authManager = security.getSecuritySystem().getAuthorizationManager(UserManager.DEFAULT_SOURCE)
def existingRole = authManager.getRole(newRoleId)
if(user != null) {
    RoleIdentifier newRole = new RoleIdentifier(role_realm, existingRole.roleId);
    user.addRole(newRole)
    security.securitySystem.setUsersRoles(user.getUserId(), realm, user.getRoles());
} else {
    log.warn("No user with ID of $userId found.")
}