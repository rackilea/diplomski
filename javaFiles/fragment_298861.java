@Component(value="customExpressionHandler")
public class CustomWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {

    @Override
    protected SecurityExpressionRoot createSecurityExpressionRoot(
            Authentication authentication, FilterInvocation fi) {

        WebSecurityExpressionRoot expressionRoot = new CustomWebSecurityExpressionRoot(authentication, fi);

        return expressionRoot;
}}