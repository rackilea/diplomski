@WebFilter("/*")
public class ExpireFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        Date expire = new Date(1420092000000L); // 2015-01-01
        Date now = new Date();
        if (now.before(expire)) {
            chain.doFilter(request, response); // On time
        } else {
            response.getWriter().print("Application expired!");
        }
    }

    @Override
    public void destroy() {}

}