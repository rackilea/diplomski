public class ServletConfig extends GuiceServletContextListener {
@Override
protected Injector getInjector() {
    return Guice.createInjector(new ServletModule() {
        @Override
        protected void configureServlets() {
            super.configureServlets();

            serve("/").with(TestServlet.class);
        }
    });
}