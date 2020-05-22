public class OrgIdFilter implements Filter {
   public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws java.io.IOException, javax.servlet.ServletException {
      int orgId = 0;
      HttpServletRequest req = (HttpServletRequest) servletRequest;
      HttpSession session = req.getSession();
      orgId = Integer.parseInt(session.getAttribute("OrganizationalIdAttr"));
      try {
         OrgId.orgId.set(orgId);
         filterChain.doFilter(servletRequest, servletresponse);
      } finally {
         OrgId.orgId.set(null); // Important to clear after request !!
      }
   }
}