public class UserFilter implements Filter { 
@Override
public void init(FilterConfig filterConfig) throws ServletException {

}

@Override
public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {

    HttpServletRequest req = null;
    boolean valid = false;
    PrintWriter out = null;

    if (request instanceof HttpServletRequest) {

        req = (HttpServletRequest) request;
        // TODO extract site info from url ...
        // TODO perform check ...
        // valid = ...
    }

    if (valid) {
        chain.doFilter(request, response);
    } else {

        response.setContentType("text/html");
        out = response.getWriter();
        out.println("<html><head><title>Your specific response</title></head><body>");
        out.println("<h2>Sorry, Unknown URL!</h2>");

        out.println("</body></html>");
        out.close();
    }
}

@Override
public void destroy() {

}