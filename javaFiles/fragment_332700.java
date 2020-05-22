@Bean
public UrlRewriteFilter urlRewriteFilter(final ServletContext servletContext) throws ServletException {
    UrlRewriteFilter urlRewriteFilter = new UrlRewriteFilter();
    urlRewriteFilter.init(new FilterConfig() {
        private final Map<String, String> params = new HashMap<String, String>();
        {
            params.put("confPath", "urlrewrite.xml");
        }

        @Override
        public String getFilterName() {
            return "UrlReriteFilter";
        }

        @Override
        public ServletContext getServletContext() {
            return servletContext;
        }

        @Override
        public String getInitParameter(String name) {
            return params.get(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return Collections.enumeration(params.keySet());
        }
    });

    return urlRewriteFilter;
}