public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
throws ServletException
{
   request.setCharacterEncoding("UTF-8");
   chain.doFilter(request, response);
}