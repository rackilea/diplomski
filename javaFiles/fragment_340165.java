@WebFilter(value = "/*")
public class TenantExtractorFilter implements Filter {

  @Inject private RequestDataHolder holder;

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    //obtain tenant id, and store in threadlocal
    holder.setTenantId(req.getHeader("X-TENANT"));
    chain.doFilter(request, response);
  }
}