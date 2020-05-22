@Component
public class SecurityPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (!(targetDomainObject instanceof TopAppEntity))
            throw new IllegalArgumentException();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return permissionService.isAuthorized(userDetails.getUser(), targetDomainObject, permission.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        try {
            return permissionService.isAuthorized(userDetails.getUser(), targetId,
                    Class.forName(targetType), String.valueOf(permission));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No class found " + targetType);
        }
    }

    public boolean hasPermission(Authentication authentication, Collection<Object> targetDomainObjects, Object permission) {
        for (Object targetDomainObject : targetDomainObjects) {
            if (!hasPermission(authentication, targetDomainObject, permission))
                return false;
        }
        return true;
    }

}