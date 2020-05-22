public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {

            @Override
            protected void configureServlets() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("symbolMapsDirectory", "WEB-INF/classes/symbolMaps/");
                serve("/gwtRequest").with(RequestFactoryServlet.class, params);


            }

        });
    }

}