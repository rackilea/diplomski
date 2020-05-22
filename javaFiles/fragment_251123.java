private ServletModule createServletModule() {
    return new ServletModule() {
        @Override
        protected void configureServlets() {

            Map<String, String> params = new HashMap<String, String>();  
            params.put(WicketFilter.FILTER_MAPPING_PARAM, "/*");
            params.put("applicationClassName", "com.project.application.WicketApplication");

            bind(AuthorizeServlet.class);
            bind(AuthorizeCallbackServlet.class);
            bind(WicketFilter.class).in(Singleton.class);
            bind(WebApplication.class).to(WicketApplication.class);

            serve("/authorize").with(AuthorizeServlet.class);
            serve("/authorizecallback").with(AuthorizeCallbackServlet.class);
            filter("/*").through(WicketFilter.class, params);
        }

    };