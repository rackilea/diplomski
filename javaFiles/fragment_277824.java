public class Utf8EncodingFilter implements Filter {

 public void init(FilterConfig config) throws ServletException {}

 public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
 throws IOException, ServletException {
  request.setCharacterEncoding("utf-8");
  next.doFilter(request, response);
 }

 public void destroy(){}
}