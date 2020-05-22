public class MvcWebApplicationInitializer extends
      AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] { WebSecurityConfig.class };
  }

  // ... other overrides ...
}