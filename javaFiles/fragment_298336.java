public class HttpFilter implements Filter
{
  public void doFilter(ServletRequest request, ServletResponse response,
       FilterChain filterChain) throws IOException, ServletException
   {
       HttpServletRequest httpRequest = (HttpServletRequest) request;        
       if(httpRequest.getMethod().equalsIgnoreCase("PUT")){

       }
       filterChain.doFilter(request, response);
   }
    // other methods etc
}