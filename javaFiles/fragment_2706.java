public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
        {
        HttpServletResponse res = (HttpServletResponse)response;
        chain.doFilter(request, response);
        res.addHeader("X-FRAME-OPTIONS", mode );
        }