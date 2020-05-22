public class EatHeadersFilters implements Filter
{
   private List<String> headers;
   public void init(FilterConfig filterConfig) throws ServletException
   {
      String headersString = filterConfig.getInitParameter("headers");
      String[] strings = headersString.split(",");
      headers = Arrays.asList(strings);
   }

   public void doFilter(ServletRequest request, ServletResponse response,
         FilterChain filterChain) throws IOException, ServletException
   {
       filterChain.doFilter(request, 
           new HttpServletResponseWrapper((HttpServletResponse) response){
              public void addHeader(String headerName, String headerValue)
              {
                  if(!headers.contains(headerName)){
                   super.addHeader(headerName, headerValue);
                  } else {
                   //eat the header
                  }
              }
         });
    }

   public void destroy()
   {
   }
}