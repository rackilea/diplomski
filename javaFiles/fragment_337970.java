public class SampleFilter implements Filter {

    FilterConfig config; //setter and getters ommited

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            this.config=filterConfig;  
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (!isLoggedIn(request, response)) {
            getFilterConfig().getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
           chain.doFilter(request, response); 
        }
    }