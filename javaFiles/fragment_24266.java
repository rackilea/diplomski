@WebFilter(urlPatterns = "/*")
public class CidFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        String cid = extractCidParameterIfAny(request);
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (cid != null) {
            String forwardUrl = buildForwardUrlWithCidParameter(cid);
            HttpServletRequest wrapper = new CidHttpServletRequest(httpRequest);
            httpRequest.getRequestDispatcher(forwardUrl).forward(wrapper, response);
        } else {
            chain.doFilter(request, response);
        }
    }

}