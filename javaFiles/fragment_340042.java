/**
*
* @author Lennart Koester (University of Innsbruck, 2012)
*/
@Service
public class RedirectFilter implements Filter {

@Override
public void init(FilterConfig filterConfig) throws ServletException {
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    String queryString = ((HttpServletRequest) request).getQueryString();
    if (queryString != null) {
        RedirectAwareResponseWrapper res = new RedirectAwareResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, res);
        if (res.isRedirected()) {
            ((HttpServletResponse) response).sendRedirect(res.getLocation() + "?" + queryString);
        }
    } else {
        chain.doFilter(request, response);
    }
}

@Override
public void destroy() {
}

class RedirectAwareResponseWrapper extends HttpServletResponseWrapper {

    private boolean redirected = false;
    private String location;

    public RedirectAwareResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        redirected = true;
        this.location = location;
        //IMPORTANT: don't call super() here
    }

    public boolean isRedirected() {
        return redirected;
    }

    public String getLocation() {
        return location;
    }

}
}