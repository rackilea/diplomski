@Bean
public ServletContextInitializer servletContextInitializer(@Value("${secure.cookie}") boolean secure) {
    return new ServletContextInitializer() {

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
            servletContext.getSessionCookieConfig().setSecure(secure);
        }
    };
}