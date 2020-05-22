public class MyWebAppInitializer implements WebApplicationInitializer {

 @Override
 public void onStartup(ServletContext container) {
  // Create the 'root' Spring application context
  AnnotationConfigWebApplicationContext rootContext =
                       new AnnotationConfigWebApplicationContext();
  rootContext.register(WebSpringConfig.class);

  // Manage the lifecycle of the root application context
  container.addListener(new ContextLoaderListener(rootContext));

  // Create the dispatcher servlet's Spring application context
  AnnotationConfigWebApplicationContext dispatcherContext =
                     new AnnotationConfigWebApplicationContext();
  dispatcherContext.register(DispatcherConfig.class);

  // Register and map the dispatcher servlet
  ServletRegistration.Dynamic dispatcher =
    container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}