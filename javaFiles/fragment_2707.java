public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
        {
        HttpServletResponse res =
            new javax.servlet.http.HttpServletResponseWrapper(
                                            (HttpServletResponse)response );
        chain.doFilter(request, res);
        res.addHeader("X-FRAME-OPTIONS", mode );
        }