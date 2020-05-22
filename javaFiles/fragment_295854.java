@WebFilter(urlPattern = "/")
public class RedirectDetectFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        // Detect and do redirect here
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        HttpServletResponse servletResponse = (HttpServletResponse)response
        if(isRedirectNeeded(servletRequest, servletResponse) {
             // build absoulute url with protocol:
             String protocol = servletRequest.getheader(X-FORWARDED-PROTO);
             String absUrl = format("%s://%s/%s", protocol, host, redirectUrl);
             servletResponse.sendRedirect(absUrl);
        } else {
            chain.doFilter(request, response);
        }
    }
}