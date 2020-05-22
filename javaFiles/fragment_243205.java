public class GZIPFilter implements Filter 
{
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException 
    {
        if (servletRequest instanceof HttpServletRequest) 
        {
            HttpServletRequest httpRequest;
            HttpServletResponse httpResponse;
            String acceptedEncoding, accept;
            GZIPResponseWrapper wrappedResponse;

            httpRequest = (HttpServletRequest) servletRequest;
            httpResponse = (HttpServletResponse) servletResponse;

            accept = httpRequest.getHeader("accept");
            acceptedEncoding = httpRequest.getHeader("accept-encoding");

            if (acceptedEncoding != null && acceptedEncoding.indexOf("gzip") != -1 && !accept.equals("image/png,image/*;q=0.8,*/*;q=0.5")) 
            {
                wrappedResponse = new GZIPResponseWrapper(httpResponse);
                filterChain.doFilter(servletRequest, wrappedResponse);
                wrappedResponse.finishResponse();
                return;
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void init(FilterConfig filterConfig) 
    {

    }

    public void destroy() 
    {

    }
}