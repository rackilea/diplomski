@Bean
public ServletContextInitializer servletContextInitializer() {
    return new ServletContextInitializer() {

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException
        {
            servletContext.getSessionCookieConfig().setDomain(".domain-name.com");
        }
    };

}