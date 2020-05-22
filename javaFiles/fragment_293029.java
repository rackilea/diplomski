public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {                
    String path = ((HttpServletRequest) request).getRequestURI();
    if (path.contains("login.html")) //login page                                                
        chain.doFilter(request, response); //proceed to the page
    } else {            
        //conditions here
    }
}