public class IsSecureFilter extends GenericFilterBean {

private boolean isSecure;
private int port;

@Override
public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = new RequestWrapper((HttpServletRequest) request);
    HttpServletResponse res = (HttpServletResponse) response;
    this.isSecure = req.isSecure();
    this.port = req.getLocalPort();


    System.out.println("[DEBUG] : isSecure FILTER :: " + isSecure);
    System.out.println("[DEBUG] : port FILTER :: " + port);
    System.out.println("[DEBUG] : URL :: " + req.getRequestURL());
    String url = req.getRequestURL().toString().toLowerCase();
    if(url.endsWith("/login") && url.startsWith("http:") && port == 8080){
        url = url.replace("http:", "https:");
        String queries = req.getQueryString();
        if (queries == null) {
            queries = "";
        } else {
            queries = "?" + queries;
        }
        url += queries;
        res.sendRedirect(url);
    }
    else {
        chain.doFilter(req, response);
    }
}

public boolean isSecure() {
    return this.isSecure;
}

public boolean setIsSecure(boolean isSecure) {
    return this.isSecure = isSecure;
}

public int getPort() {
    return port;
}

public void setPort(int port) {
    this.port = port;
}