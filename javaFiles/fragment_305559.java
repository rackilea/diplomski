@Configuration
public class WebServicesConfiguration extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean mvcDispatcherServlet(ApplicationContext context) {
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.setApplicationContext(context);

        return new ServletRegistrationBean(servlet, "/dummy");
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/");
    }
}