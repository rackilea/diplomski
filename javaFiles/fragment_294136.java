public class TestingWrapperFilter implements Filter {
    private Object credentials = "password";
    private String rolePrefix = "ROLE";

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        Principal principal = req.getUserPrincipal();
        if (principal != null) {
            Authentication auth;
            auth = (principal instanceof Authentication) ? (Authentication) principal :
                    new TestingAuthenticationToken(principal, credentials);
            SecurityContext sc = new SecurityContextImpl();
            sc.setAuthentication(auth);
            SecurityContextHolder.setContext(sc);
        }
        else {
            SecurityContextHolder.clearContext();
        }
        sr = new SecurityContextHolderAwareRequestWrapper(req, rolePrefix);
        fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
    }

    public void setCredentials(Object credentials) {
        this.credentials = credentials;
    }

    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }
}