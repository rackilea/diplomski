public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
  throws IOException, ServletException {

      RequestContext.begin(ctx, request, response); //initialize
      try {
         //other stuff here

         //forward request to next filter, or the servlet itself
         chain.doFilter(request, response);
      } finally {   
         RequestContext.reset();
      }
}