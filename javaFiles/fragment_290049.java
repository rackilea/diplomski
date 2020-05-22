public class CORSFilter implements Filter {

public CORSFilter() {
}

public void init(FilterConfig fConfig) throws ServletException {
}

public void destroy() {
}

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
    ((HttpServletResponse) response).addHeader("Access-Control-Allow-Credentials", "true");
    ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,PATCH,DELETE");
    ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "X-Requested-With");
    chain.doFilter(request, response);
}