public void doFilter(ServletRequest request, final ServletResponse response, FilterChain chain) throws IOException, ServletException {
    final Map<String, List<String>> headers = new HashMap<String, List<String>>();
    chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
        @Override public void setHeader(String name, String value) {
            List<String> values = new ArrayList<String>();
            values.add(value);
            headers.put(name, values);
            super.setHeader(name, value);
        }

        @Override public void addHeader(String name, String value) {
            List<String> values = headers.get(name);
            if (values == null) {
                values = new ArrayList<String>(); 
                headers.put(name, values);
            }
            values.add(value);
            super.addHeader(name, value);
        }
    });
    logger.log(headers);
}