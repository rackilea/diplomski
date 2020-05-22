public class SessionContext implements Filter {

    private static final ThreadLocal<HttpSession> session = new ThreadLocal<HttpSession>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        return;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        session.set(((HttpServletRequest)servletRequest).getSession());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        return;
    }

    public static HttpSession getSession(){
        return session.get();
    }

    public static User getUser(){
        return (User) session.get().getAttribute(UserService.USER);
    }
}