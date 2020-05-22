@Service
public class PermissionService {

    public boolean isAuthorized(User user, TopAppEntity domainEntity, String permission) {
        // removed instanceof checks and can operate on domainEntity directly
        if (domainEntity.getId() == null) {
            // check authorities and give response
        } else {
            // check ACL and give response
        }
    }
}