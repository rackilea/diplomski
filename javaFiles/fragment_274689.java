public class CountingFilter implements Filter {

   public void doFilter(...) {
       chain.doFilter(request, new SizeCountingHttpServletResponse(response));
   }

   public static class SizeCountingHttpServletResponse extends HttpServletResponseWrapper {

      ....
      @Override
      public OutputStream getOutputStream() {
          return new CountingOutputStream(super.getOutputStream());
      }
      // same with getWriter()..
   }

   public static class CountingOuputStream extends OutputStream {
       private int size;
       // delegate all methods to the original OutputStream
       // count the number of byte written and store in the 'size' field.
   }

}