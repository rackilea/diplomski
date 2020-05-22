@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private PermissionService permissionService;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        PermissionEvaluator permissionEvaluator = new SecurityPermissionEvaluator(permissionService);
        return new CustomMethodSecurityExpressionHandler(permissionEvaluator);
    }
}