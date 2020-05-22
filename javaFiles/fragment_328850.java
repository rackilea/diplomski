public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private final PermissionEvaluator permissionEvaluator;
    private final Authentication authentication;

    private Object filterObject;
    private Object returnObject;
    private Object target;

    public CustomMethodSecurityExpressionRoot(Authentication authentication, PermissionEvaluator permissionEvaluator) {
        super(authentication);
        this.authentication = authentication;
        this.permissionEvaluator = permissionEvaluator;
        super.setPermissionEvaluator(permissionEvaluator);
    }

    public boolean hasAccessToCollection(Collection<Object> collection, String permission) {
        for (Object object : collection) {
            if (!permissionEvaluator.hasPermission(authentication, object, permission))
                return false;
        }
        return true;
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public Object getThis() {
        return target;
    }
}