@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    ...

    @Configuration
    protected static class AclMethodSecurityConfig
        extends GlobalMethodSecurityConfiguration {

        private MethodSecurityExpressionHandler aclExpressionHandler;

        @Autowired
        @Qualifier("aclExpressionHandler")
        public void setAclExpressionHandler(
            MethodSecurityExpressionHandler aclExpressionHandler) {

            this.aclExpressionHandler = aclExpressionHandler;
        }

        @Override
        protected MethodSecurityExpressionHandler createExpressionHandler() {
            return aclExpressionHandler;
        }
    }
}