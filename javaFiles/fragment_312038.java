public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
                throws IOException, ServletException 
{
    HttpServletResponse res = (HttpServletResponse) response;

    try
    {
        chain.doFilter(request, res);
    }
    finally 
    {
        res.setHeader("Set-Cookie", null);
    }
}