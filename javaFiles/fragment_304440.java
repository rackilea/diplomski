public class ResponseLoggingFilter extends GenericFilterBean {

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
      HttpServletResponse responseWrapper = loggingResponseWrapper((HttpServletResponse) response);     
      filterChain.doFilter(request, responseWrapper);
   }

   private HttpServletResponse loggingResponseWrapper(HttpServletResponse response) {
      return new HttpServletResponseWrapper(response) {
         @Override
         public ServletOutputStream getOutputStream() throws IOException {
            return new DelegatingServletOutputStream(
               new TeeOutputStream(super.getOutputStream(), loggingOutputStream())
            );
         }
      };
   }

   private OutputStream loggingOutputStream() {
      return System.out;
   }
}