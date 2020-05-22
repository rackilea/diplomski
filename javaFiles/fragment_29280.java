public class ServletAcessFilter implements Filter
{
  public void init(FilterConfig filterConfig) throws ServletException
  {

  }

  public void doFilter(ServletRequest request, ServletResponse response,
  FilterChain filterChain) throws IOException, ServletException
  {
    //validate the request, check if the request can be forwarded to servlet.
    if(request.getParameter("P").equalsIgnoreCase("123")){
        filterChain.doFilter(request, response);
    } else {
        //write what you want to do if the request has no access
        //below code will write 404 not found, you can do based on your requirement
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(404);
    }
  }

  public void destroy()
  {

  }
}