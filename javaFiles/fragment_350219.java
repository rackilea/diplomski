@Autowired
private ApplicationContext context;

@Override
protected MethodSecurityExpressionHandler expressionHandler() {
    DefaultMethodSecurityExpressionHandler expressionHandler =
            new DefaultMethodSecurityExpressionHandler();
    expressionHandler.setPermissionEvaluator(appPermissionEvaluator());
    expressionHandler.setApplicationContext(context);
    return expressionHandler;
}