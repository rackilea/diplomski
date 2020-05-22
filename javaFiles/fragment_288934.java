public class MyFilter implements Filter {

    public void init(FilterConfig fc) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new CustomHttpServletRequestWrapper((HttpServletRequest)request), response);

    }

    public void destroy() {

    }

}