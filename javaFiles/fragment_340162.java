@WebFilter(value = "/*")
public class TenantExtractorFilter implements Filter {
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    //obtain tenant id, and store in threadlocal
    ThreadLocalHolder.setTenantId(req.getHeader("X-TENANT"));
    chain.doFilter(request, response);
  }
}