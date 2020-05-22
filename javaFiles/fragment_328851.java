public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    private final PermissionEvaluator permissionEvaluator;

    public CustomMethodSecurityExpressionHandler(PermissionEvaluator permissionEvaluator) {
        this.permissionEvaluator = permissionEvaluator;
        super.setPermissionEvaluator(permissionEvaluator);
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
            Authentication authentication, MethodInvocation invocation) {
        CustomMethodSecurityExpressionRoot root =
                new CustomMethodSecurityExpressionRoot(authentication, permissionEvaluator);
        root.setTrustResolver(new AuthenticationTrustResolverImpl());
        root.setRoleHierarchy(getRoleHierarchy());
        return root;
    }
}