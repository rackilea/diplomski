@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config)
        throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String requestPath = httpServletRequest.getRequestURI();

        if (needsAuthentication(requestPath) ||
            session == null ||
            session.getAttribute("user") == null) { // change "user" for the session attribute you have defined

            response.sendRedirect(request.getContextPath() + "/login"); // No logged-in user found, so redirect to login page.
        } else {
            chain.doFilter(req, res); // Logged-in user found, so just continue request.
        }
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }

    //basic validation of pages that do not require authentication
    private boolean needsAuthentication(String url) {
        String[] validNonAuthenticationUrls =
            { "Login.jsp", "Register.jsp" };
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }
}