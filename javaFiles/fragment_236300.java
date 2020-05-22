class MyExpressionHandler extends DefaultMethodSecurityExpressionHandler {
    @Override
    protected MethodSecurityExpressionOperations
        createSecurityExpressionRoot(Authentication a, MethodInvocation mi) {
        return new MyRoot(super.createSecurityExpressionRoot(a, mi));
    }
}

@EnableGlobalMethodSecurity(prePostEnabled=true)
class UsingCustomExpressionHandler extends GlobalMethodSecurityConfiguration {
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new MyExpressionHandler();
    }
}