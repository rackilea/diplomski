public class MyFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    ContextHolder.setSubject(request.getAttribute('subject'));
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    ContextHolder.removeSubject();
  }
}


public class ContextHolder {

  private static final ThreadLocal<String> SUBJECT = new ThreadLocal<String>() {
    @Override
    protected String initialValue() {
      return "empty";
    }
  };

  public static void setSubject(String subject) {
    SUBJECT.set(subject);
  }

  public static String getSubject() {
    return SUBJECT.get();
  }

  public static void removeSubject() {
    SUBJECT.remove();
  }
}