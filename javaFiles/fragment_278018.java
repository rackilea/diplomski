public class ApplicationFilter implements Filter {

    private Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) 
        throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Principal principal = request.getUserPrincipal();
        HttpSession session = request.getSession();

        if (principal != null && session.getAttribute("THE_PRINCIPAL") == null) {

            // update the current session
            session.setAttribute("THE_PRINCIPAL", session);

            // get the username from the principal
            // (assumes you using container based authentication)
            String username = principal.getName();

            // invalidate previous session if it exists
            HttpSession s = sessions.get(username);
            if (s != null)
                s.invalidate();

            // register this session as the one for the user
            sessions.put(username, session);

        }

        chain.doFilter(servletRequest, servletResponse);

    }

}