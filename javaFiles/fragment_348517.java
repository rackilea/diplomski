public class SecurityWebApplicationInitializer
      extends AbstractSecurityWebApplicationInitializer {
    protected String getDispatcherWebApplicationContextSuffix() {
        return "mvc";
    }
}