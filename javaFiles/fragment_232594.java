@Configuration
@ComponentScan(value="com.spring.webapp.lojavirtual")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    protected MethodSecurityExpressionHandler createExpressionHandler() {
        System.out.println("MethodSecurityConfig.createExpressionHandler");
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new CustomPermissionEvaluator());
        return expressionHandler;
    }

}