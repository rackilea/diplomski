public class ApplicationContextProvider implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {

        camelContext=(CamelContext)context.getBean("mainCamelContext");
        camelContext.addRoutes(new MyRouteBuilder(camelContext, "another1","A"));
        camelContext.addRoutes(new MyRouteBuilder(camelContext, "another2","B"));

..