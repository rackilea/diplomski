public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        @SuppressWarnings("unchecked")
        Map<String, String[]> parms = request.getParameterMap();

        if (parms.containsKey("token")) {