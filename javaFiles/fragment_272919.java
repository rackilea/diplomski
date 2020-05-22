@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = false)
    public class CustomMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {
    @Autowired
    ApplicationContext applicationContext;
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        CustomMethodSecurityExpressionHandler handler = new  CustomMethodSecurityExpressionHandler();
        handler.setApplicationContext(applicationContext);
        return handler;
    }
    @Bean
    public MethodSecurityExpressionHandler expressionHandler() {
        return createExpressionHandler();
    }
}

public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
    private ApplicationContext applicationContext;
    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
                                                                              MethodInvocation invocation) {
        final CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication);
        root.setThis(invocation.getThis());
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(this.trustResolver);
        root.setRoleHierarchy(getRoleHierarchy());
        root.setRepositoryService(applicationContext.getBean(RepositoryService.class);
        return root;
    }

    @Override
    protected void setApplicationContext(applicationContext){
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }
}


public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;
    private Object target;
    private RepositoryService repositoryService;

    public boolean canViewFolder(String uuid){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         return repositoryService.checkFolderPermissions(currentUser.getUsername(), uuid);
    }

    public CustomMethodSecurityExpressionRoot(Authentication a) {
        super(a);
    }

    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    public Object getFilterObject() {
        return filterObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    void setThis(Object target) {
        this.target = target;
    }

    public Object getThis() {
        return target;
    }

    public void setRepositoryService(RepositoryService repositoryService){
        this.repositoryService = repositoryService;
    }
}